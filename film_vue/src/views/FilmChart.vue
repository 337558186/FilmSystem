<template>
	<div id="myChart" :style="{width: '1300px', height: '600px'}"></div>
</template>

<script>
    export default {
        name: 'FilmChart',
        data () {
            return {
                msg: 'Welcome to Your Vue.js App',
                xData: ['11','22','33'],
				yData: [2,3,4]
            }
        },
        mounted(){
            this.getX();
            this.getY();
            this.drawLine();
        },
        methods: {
             drawLine(){

                // 基于准备好的dom，初始化echarts实例
                let myChart = this.$echarts.init(document.getElementById('myChart'))
                // 绘制图表

                myChart.setOption({
                    title: { text: '影片统计' },
                    tooltip: {},
                    xAxis: {
                        data: this.xData
                    },
                    yAxis: {},
                    series: [{
                        name: '数量',
                        type: 'bar',
                        data: this.yData
                    }]
                });
            },
            async getX(){   /*同步请求，异步可能出问题，方法调用时数据还没完成替换*/
                var res =  await this.axios.get("type/typeList1")

					for (let i=0;i<res.data.length;i++){
                        this.xData[i] = res.data[i].typeName
					}
                    console.log(this.xData)


			},
            async getY(){
                var res =  await this.axios.get("film/countFilm")
                    for (let i=0;i<res.data.length;i++){
                        this.yData[i] = res.data[i]
                    }
                    console.log(this.yData)
                     this.drawLine();

			},
        },
		watch:{
            'xData':function(){

                console.log('watch_xData:'+this.xData);
			}
		}
    }
</script>

<style scoped>

</style>
