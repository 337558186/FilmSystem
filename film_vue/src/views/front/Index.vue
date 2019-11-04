<template>
	<div style="">
		<div style="background-color: #d3fffc;height: 80px;padding-top: 30px;">
			<div style="float: left;margin-left: 600px;font-size: 30px">
				<router-link :to="{path:'/findex/welcome'}" > 主页</router-link>
			</div>
			<div style="float: left;margin-left: 20px;font-size: 30px">
				<router-link :to="{path:'/findex/allFilm'}"> 全部电影</router-link>
			</div>
			<div style="float: left;margin-left: 20px;font-size: 30px">
				<router-link :to="{path:'/findex/home'}"> 个人中心</router-link>
			</div>
			<!--<div style="float: left;margin-left:1400px;margin-top: -50px;display:none" ref="abc">
				<router-link :to="{path:'/index/welcome'}"> 进入后台管理</router-link>
			</div>-->
		</div>

		<div style="background-color: #e7f1ff;height: 2800px;margin-top: -24px;">
			<router-view></router-view>
		</div>

	</div>
</template>

<script>

    export default {
        name: 'Index',
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
                }]
			}
		},
       mounted () {
           // console.log(this.$refs.abc.style.cssText)
		   /*if(this.$store.getters.user.roleId !== 1){
               this.$refs.abc.style.display = 'inline';
		   }*/
       }
    }
</script>

<style scoped>
	a {
		text-decoration: none;
	}
	.router-link-active {
		text-decoration: none;
	}
</style>
