<template>
	<div>
		<br>
		<h1 style="margin-left: -1300px;">最近更新</h1>
		<div v-for="item in lastUpdated" :key="item.filmId"  style="margin-bottom: 10px">
			<div class="contract-item" style="float: left;width: 285px;margin-left: 10px;border: 2px solid #17d6ff">
				<div>
					<img :src="item.image.imageUrl" alt="电影图片" width="280" height="100px"/>
				</div>
				<div style=""><p>电影名称：{{item.filmName}}</p></div>
				<div><p>导演：{{item.director}}</p></div>
				<div><p>电影时长：{{item.duration}}分钟</p></div>
				<div><p>电影价格：{{item.price}}元</p></div>

				<el-button size="mini" type="success"  @click="buyFilm(item.filmId)">购买</el-button>
				<el-button size="mini" type="success"  @click="watch(item.filmId,item.price)">播放</el-button>
			</div>
		</div>
		<br><br><br><br>

		<h1 style="margin-left: -1300px;">最高评分</h1>
		<div v-for="item in scoreFilm" :key="item.comments.id" >
			<div class="contract-item" style="float: left;width: 285px;margin-left: 10px;border: 2px solid #17d6ff">
				<div>
					<img :src="item.image.imageUrl" alt="电影图片" width="280" height="100px"/>
				</div>
				<div style=""><p>电影名称：{{item.filmName}}</p></div>
				<div><p>导演：{{item.director}}</p></div>
				<div><p>电影时长：{{item.duration}}分钟</p></div>
				<div><p>电影价格：{{item.price}}元</p></div>
				<div><p>电影评分：{{item.comments.score}}分</p></div>

				<el-button size="mini" type="success"  @click="buyFilm(item.filmId)">购买</el-button>
				<el-button size="mini" type="success"  @click="watch(item.filmId,item.price)">播放</el-button>
			</div>
		</div>
		<br><br><br><br>

		<h1 style="margin-left: -1300px;">猜你喜欢</h1>
		<div v-for="item in tableData" :key="item.filmId" >
			<div class="contract-item" style="float: left;width: 285px;margin-left: 10px;border: 2px solid #17d6ff">
				<!--<div>
					<img :src="item.image.imageUrl" alt="电影图片" width="280" height="100px"/>
					&lt;!&ndash;{{item.image.imageUrl}}&ndash;&gt;
				</div>-->
				<div style=""><p>电影名称：{{item.filmName}}</p></div>
				<!--<div><p>导演：{{item.director}}</p></div>
				<div><p>电影时长：{{item.duration}}分钟</p></div>
				<div><p>电影价格：{{item.price}}元</p></div>-->
				<!--
				<button @click="buy(item.filmId)">购买</button>
				<button @click="watch(item.filmId,item.price)">播放</button>-->
			</div>
		</div>


	</div>
</template>

<script>
    export default {
        name: 'Welcome',
        data(){
            return{
                tableData: [{
                    filmName: '111'
                },{
                    filmName: '111'
                },{
                    filmName: '111'
                },{
                    filmName: '111'
                },{
                    filmName: '111'
                }],
				lastUpdated: [],
				scoreFilm: []
            }
        },
		created () {
			this.LastUpdated();
			this.score();
        },
		methods: {
            LastUpdated(){
                this.axios.get("film/lastUpdated").then( res =>{
                    this.lastUpdated = res.data
				})
			},
			/*首页最高评分*/
			score(){
			    this.axios.get("film/listFilmByScore").then( res =>{
			        this.scoreFilm = res.data
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
                        /*存储电影信息至vuex*/
                        this.axios.post("film/getFilmById",{
                            filmId: id,
                        }).then( res =>{
                            this.$store.commit('handleFilm', res.data)  /*存至vuex  主页展示用户*/
                        })
                        this.$router.push({path: '/findex/watch'})
					}
				})
            }
        },

    }
</script>

<style scoped>

</style>
