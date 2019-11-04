<template>
<div>
	<div style="width: 460px;height: 600px;float: left;margin-left: 30px; border-right :1px solid #000000">
		<h1 style="padding-right: 100px;">个人信息</h1>
		<table style="line-height: 50px">
			<tr>
				<td style="padding-left: 120px;">用户名</td>
				<td>{{$store.getters.user.userName}}</td>
			</tr>
			<tr>
				<td style="padding-left: 120px;">密码</td>
				<td>{{$store.getters.user.password}}</td>
			</tr>
			<tr>
				<td style="padding-left: 120px;">手机号</td>
				<td>{{$store.getters.user.phone}}</td>
			</tr>
			<tr>
				<td style="padding-left: 120px;">会员等级</td>
				<td>{{$store.getters.user.memberId}}</td>
			</tr>
			<tr>
				<td style="padding-left: 120px;">会员积分</td>
				<td>{{$store.getters.user.integral}}</td>
			</tr>

			<tr>
				<td><el-button type="primary" round size="mini " @click="handleEdit">编辑账户</el-button></td>
				<td><el-button type="primary" round size="mini " @click="handleDelete">删除账户</el-button></td>
			</tr>
		</table>
	</div>

	<div style="width: 510px;height: 600px;float: left;; border-right :1px solid #000000">

		<div style="width: 488px;height: 600px;float: left;margin-left: 30px; ">
			<h1 style="padding-right: 100px;">购买记录</h1>

			<el-table
				:data="tableData"
				style="width: 460px;">
				<el-table-column
					prop="orderId"
					label="编号"
					width="180">
				</el-table-column>

				<el-table-column
					prop="user.userName"
					label="用户名"
					width="180">
				</el-table-column>

				<el-table-column
					prop="film.filmName"
					label="电影名称">
				</el-table-column>
			</el-table>
		</div>
	</div>


	<div style="width: 480px;height: 600px;float: left;">
		<div style="width: 488px;height: 600px;float: left;margin-left: 30px;">
			<h1 style="padding-right: 100px;">观看历史&nbsp;&nbsp;&nbsp;<el-button size="mini" type="warning" @click="clearHistory">清空历史记录</el-button></h1>

			<el-table
				:data="listHistory"
				style="width: 450px;">
				<el-table-column
					prop="id"
					label="编号"
					width="180">
				</el-table-column>

				<el-table-column
					prop="film.filmName"
					label="电影名称"
					width="180">
				</el-table-column>

				<el-table-column
					prop="date"
					label="观看时间" :formatter="dateFormat">
				</el-table-column>


			</el-table>
		</div>
	</div>


</div>
</template>

<script>
    import moment from 'moment'  /*日期格式化*/
    export default {
        name: 'Home',
		data(){
            return{
                tableData: [],
				listHistory: []
			}
		},
		created(){
            this.showList();
            this.history();
		},
		methods:{
            /*查询订单*/
            showList(){
                this.axios.post("order/show",{
                    user:this.$store.getters.user
				}).then( res =>{
				    this.tableData = res.data
				})
			},
			/*查看历史记录*/
			history(){
			    this.axios.post("history/list",{
			        userId:this.$store.getters.user.userId
				}).then( res =>{
				    this.listHistory = res.data
				})
			},
            /*日期处理*/
            dateFormat: function (row, column) {
                var date = row[column.property]
                if (date === undefined) {
                    return ''
                }
                return moment(date).format('YYYY-MM-DD HH:mm:ss')
            },
			/*编辑用户*/
            handleEdit(){
                let userName = this.$store.getters.user.userName;
			},
			/*删除账户*/
            handleDelete(){
                let userId = this.$store.getters.user.userId;
					this.$confirm('确认删除？', '警告', {
						type: 'warning'
					}).then(() => {
						this.axios.post('user/delete',{
							userId: userId
						}).then( res =>{
							if (res.data && res.data === 'success') {
								this.$message({
									type: 'success',
									message: '删除成功'
								})
							}
							this.$router.push({path: '/login'})
						}).catch(error => {
							this.$message({
								type: 'error',
								message: '删除失败'
							})
						})
					})
			},
			/*清空历史记录*/
            clearHistory(){
                let userId = this.$store.getters.user.userId;
                this.$confirm('确认清空？', '警告', {
                    type: 'warning'
                }).then(() => {
                    this.axios.post('history/clear',{
                        userId: userId
                    }).then( res =>{
                        if (res.data && res.data === 'success') {
                            this.$message({
                                type: 'success',
                                message: '清空成功'
                            })
                        }
                        this.$router.push({path: '/findex/home'})
                    }).catch(error => {
                        this.$message({
                            type: 'error',
                            message: '清空失败'
                        })
                    })
                })
			},
		}
    }
</script>

<style scoped>
	.el-table .warning-row {
		background: oldlace;
	}

	.el-table .success-row {
		background: #f0f9eb;
	}
</style>
