<template>
	<div>

		<h1 style="margin-left: -1300px;">电影类别</h1>
		<div style="height: 50px"> <!--;border: 2px solid #17d6ff-->
			<div v-for="item in typeDate" :key="item.typeId" style="float: left;margin-left: 20px">
				<el-button @click="typeList(item)">{{item.typeName}}</el-button>
			</div>
		</div>

		<h1 style="margin-left: -1300px;">全部电影</h1>
		<div v-for="item in tableData" :key="item.filmId" v-loading="isLoaded" element-loading-test="拼命加载中">
			<div class="contract-item"
				 style="float: left;width: 280px;margin-left: 10px;border: 2px solid #17d6ff;margin-top: 5px">
				<img :src="item.image.imageUrl"  width="250" height="100px" alt="电影预览图"/>

				<div style=""><p>电影名称：{{item.filmName}}</p></div>
				<div><p>导演：{{item.director}}</p></div>
				<div><p>电影时长：{{item.duration}}分钟</p></div>
				<div><p>电影价格：{{item.price}}元</p></div>

				<el-button size="mini" type="success" round @click="buy(item.filmId)">购买</el-button>
				<el-button size="mini" type="success" round @click="watch(item.filmId,item.price)">播放</el-button>
			</div>


		</div>
	</div>
</template>

<script>
    export default {
        name: 'AllFilm',
        data () {
            return {
                tableData: [],  //所有数据
				typeDate: [],

            }
        },
        created () {
            this.showList();
            this.showType();
        },
        methods: {
            /*查询所有*/
            showList () {
                this.isLoaded = true  /*读取数据动画*/
                var arr = this
                arr.axios.get('film/listFilm')
                    .then((response) => {
                        console.log(response.data)//请求的返回体
                        arr.tableData = response.data

						// this.image1 = reqire(data[0].image.imageUrl);
                        this.isLoaded = false  /*结束读取动画*/
                    })
                    .catch((error) => {
                        console.log(error)//异常
                    })
            },
			/*所有类别*/
			showType(){
			    this.axios.get("type/typeList").then( res =>{
                    console.log(res.data)//请求的返回体
			        this.typeDate = res.data
				})
			},
			/*根据类别查询*/
            typeList(item){
                let id = item.typeId
			    console.log(id)
				this.axios.post("film/listByType",{
				    typeId: id
				}).then( res=>{
				    this.tableData = res.data;
				})
			},


			/*购买电影*/
            buy (id) {
                this.axios.post("order/query",{
                    filmId: id,
                    userId: this.$store.getters.user.userId
				}).then( res =>{
				    console.log(res)
				    if(res.data === "success"){
                        this.$message('无需重复购买');
                        /*存储电影信息至vuex*/
                        this.axios.post("film/getFilmById",{
                            filmId: id,
                        }).then( res =>{
                            this.$store.commit('handleFilm', res.data)  /*存至vuex  主页展示用户*/
                        })
                        this.$router.push({path: '/findex/watch'})
					}else if(res.data ==="failed"){
                        this.$confirm('确认购买？', '提示', {
                            type: 'info'
                        }).then(() => {
                            this.axios.post('order/add', {
                                filmId: id,
                                userId: this.$store.getters.user.userId
                            }).then(res => {
                                if ( res.data === 'success') {
                                    this.$message({
                                        type: 'success',
                                        message: '购买成功'
                                    })
                                }
                                this.axios.post("history/add",{
                                    filmId: id,
                                    userId: this.$store.getters.user.userId
                                })
                                /*存储电影信息至vuex*/
                                this.axios.post("film/getFilmById",{
                                    filmId: id,
                                }).then( res =>{
                                    this.$store.commit('handleFilm', res.data)  /*存至vuex  主页展示用户*/
                                })
                                this.$router.push({path: '/findex/watch'})
                            }).catch(error => {
                                this.$message({
                                    type: 'error',
                                    message: '购买失败'
                                })
                            })
                        })
					}
				})
            },

            /*看电影的方法*/
            watch (id, price) {
                this.axios.post("order/getById",{
                    filmId: id,
                    userId: this.$store.getters.user.userId
                }).then( res =>{
                    console.log(res)
                    if(price > 0){
                        if (res.data ==='success'){
                            this.axios.post("history/add",{
                                filmId: id,
                                userId: this.$store.getters.user.userId
                            })
							/*存储电影信息至vuex*/
							this.axios.post("film/getFilmById",{
                                filmId: id,
							}).then( res =>{
                                this.$store.commit('handleFilm', res.data)  /*存至vuex  主页展示用户*/
							})
                            this.$router.push({path: '/findex/watch'})
                        }else{
                            this.$message({
                                type: 'info',
                                message: '请先购买'
                            })
                        }
                    }else{
                        this.$router.push({path: '/findex/watch'})
                    }
                })
            }
        }
    }

</script>

<style scoped>

</style>
