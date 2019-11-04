<template>
<div>
	<div style="height: 80px;background-color: #B3C0D1;">
		<h3>{{$store.getters.film.filmName}}</h3>
		<h5>导演：{{$store.getters.film.director}}</h5>
	</div>

	<div style="height: 600px;background-color: #D3DCE6;float: left;margin-left: 100px">

		<div style="width: 1000px;height:600px;border-right: #409EFF 1px solid;float: left">

			<div>
				<!--<img :src="this.$store.getters.film.image.imageUrl"  width="800" height="500px" alt="电影预览图"/>
				<br>
				<el-button>点击播放</el-button>-->
				<video id="myVideo" class="video-js">
					<source src="../../assets/test.mp4" type="video/mp4"
					>
				</video>
			</div>

		</div>


		<div style="height: 600px;width: 350px;float: left">
			<h1>评论列表</h1>
			<hr>
			<div style="height: 350px">
				<div v-for="item in comments" :key="item.typeId" style="float: left;margin-left: 20px">
					<p><b style="color: red">{{item.user.userName}}:</b>{{item.content}}--<i style="color: brown">分数: {{item.score}}</i></p>
				</div>
			</div>

			<div style="width: 350px;height: 30px;margin-top: 80px;display: inline-block">
				<div>
					<div style="width: 260px;float: left">
						<el-input type="textarea" :rows="2" placeholder="用户输入关于电影的评论" v-model="textarea" ></el-input>
					</div>
					<div style="width: 65px;float: left">
						<el-input v-model="score" width="20px" placeholder="评分"></el-input>
					</div>
				</div>
				<el-button size="small" type="primary" @click="submitComm">提交</el-button>
			</div>
		</div>
	</div>

	<div style="width: 1400px;padding-top: 10px">
		这是电影简介
	</div>

</div>

</template>

<script>
    export default {
        name: 'Watch',
		data(){
            return{
                comments: [],
                textarea: '',
				score: 0
			}
		},
		created(){
            this.commentsList();
		},
        mounted() {
            this.initVideo();
        },
		methods:{
            submitComm(){
                this.axios.post("comments/add",{
                    userId: this.$store.getters.user.userId,
					filmId: this.$store.getters.film.filmId,
                    content: this.textarea,
					score: this.score
				}).then( res =>{
                    this.$message('评论成功');
                    this.commentsList();
				})
			},
			commentsList(){
                this.axios.post("comments/show",{
                    filmId: this.$store.getters.film.filmId,
				}).then( res =>{
				    console.log(res.data)
				    this.comments = res.data
				})
			},
            initVideo() {
                //初始化视频方法
                let myPlayer = this.$video(myVideo, {
                    //确定播放器是否具有用户可以与之交互的控件。没有控件，启动视频播放的唯一方法是使用autoplay属性或通过Player API。
                    controls: true,
                    //自动播放属性,muted:静音播放
                    //autoplay: "muted",
                    //建议浏览器是否应在<video>加载元素后立即开始下载视频数据。
                    preload: "auto",
                    //设置视频播放器的显示宽度（以像素为单位）
                    width: "1000px",
                    //设置视频播放器的显示高度（以像素为单位）
                    height: "600px"
                });
            }
		}
    }
</script>

<style scoped>
	/*el-button{
		float: left;
	}*/
	.video-js button{
		margin-top: 200px;
	}
</style>
