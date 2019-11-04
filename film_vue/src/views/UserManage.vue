<template>
	<div>
		<el-table
			:data="currentPageData.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))"
			style="width: 100%;line-height: 50px;">
			<el-table-column
				label="ID"
				prop="userId">
			</el-table-column>

			<el-table-column
				label="用户名"
				prop="userName">
			</el-table-column>

			<el-table-column
				label="密码"
				prop="password">
			</el-table-column>

			<el-table-column
				label="手机号"
				prop="phone">
			</el-table-column>

			<el-table-column
				label="会员等级"
				prop="memberId">
			</el-table-column>

			<el-table-column
				label="会员积分"
				prop="integral">
			</el-table-column>

			<el-table-column
				align="right">
				<template slot="header" slot-scope="scope">
					<el-input
						v-model="search"
						size="small"
						placeholder="输入用户名称" @keyup.enter="searchByName(search)"></el-input>
				</template>

				<template slot-scope="scope">
					<el-button type="primary" round
							   size="small "
							   @click="handleEdit(scope.$index, scope.row)">编辑
					</el-button>
					<el-button type="danger" round
							   size="small "
							   @click="handleDelete(scope.$index, scope.row)">删除
					</el-button>
				</template>
			</el-table-column>
		</el-table>

		<!--分页代码-->
		<div class="block">

			<el-button type="primary" size="mini" @click="prevPage()">
				上一页
			</el-button>
			<span>第{{currentPage}}页/共{{totalPage}}页</span>
			<el-button type="primary" size="mini" @click="nextPage()">
				下一页
			</el-button>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a>共<i>{{totalPage}}</i>页</a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<el-button type="info" size="mini" @click="turn(currentPage)">跳转至</el-button>
			<a>第</a>
			<label><input type="text" style="width: 30px;" v-model="currentPage"
						  @keyup.enter="turn(currentPage)"></label><a>页</a>

		</div>

		<!--编辑弹窗-->
		<el-dialog title="编辑用户信息" :visible.sync="updateDiaVisible">
			<el-form :model="selectedRow" size="mini" label-width="80px">
				<input type="hidden" name="id" :value="selectedRow.id"/><!--用隐藏域绑定id-->

				<el-form-item label="用户名称">
					<el-input v-model="selectedRow.userName"></el-input>
				</el-form-item>

				<el-form-item label="密码">
					<el-input v-model="selectedRow.password"></el-input>
				</el-form-item>

				<el-form-item label="电话">
					<el-input v-model="selectedRow.phone"></el-input>
				</el-form-item>
				<el-form-item label="积分">
					<el-input v-model="selectedRow.integral"></el-input>
				</el-form-item>


				<el-form-item>
					<el-button type="success" @click="update">提交</el-button>
					<el-button @click="updateDiaVisible=false">取消</el-button>
				</el-form-item>
			</el-form>

		</el-dialog>

	</div>
</template>

<script>
    export default {
        name: 'UserManager',
        data () {
            return {
                tableData: [],
                search: '',
                /*分页*/
                totalPage: 0, // 统共页数，默认为1
                currentPage: 1, //当前页数 ，默认为1
                pageSize: 7, // 每页显示数量
                currentPageData: [],//当前页显示内容

                selectedRow: {
                    userId: '',
                    userName: '',
                    password: '',
                    phone: '',
                    integral: ''
                },
                updateDiaVisible: false,
            }
        },
        created () {
            this.showList()
        },
        methods: {
            showList () {
                var arr = this
                arr.axios.get('user/userList')
                    .then((response) => {
                        console.log(response.data.length)//请求的返回体
                        arr.tableData = response.data
                        arr.totalPage = Math.ceil(response.data.length / this.pageSize)
                        arr.getCurrentPageData()
                    })
                    .catch((error) => {
                        console.log(error)//异常
                    })
            },

            /*编辑*/
            handleEdit (index, data) {
                console.log(data)
                //给selectedrow赋值
                this.selectedRow.userId = data.userId
                this.selectedRow.userName = data.userName
                this.selectedRow.password = data.password
                this.selectedRow.phone = data.phone
                this.selectedRow.integral = data.integral
                //打开窗口
                this.updateDiaVisible = true
            },
            update () {
                this.axios.post('user/update', this.selectedRow).then(res => {
                    console.log(res.data)
                    if (res.data && res.data === 'success') {
                        this.$message({
                            type: 'success',
                            message: '修改成功'
                        })
                        this.showList()
                        this.updateDiaVisible = false
                    }
                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: '修改失败'
                    })
                })
            },

            /*删除*/
            handleDelete (index, data) {
                this.selectedRow.userId = data.userId

                this.$confirm('确认删除？', '警告', {
                    type: 'warning'
                }).then(() => {
                    this.axios.post('user/delete', this.selectedRow).then(res => {
                        console.log(res.data)
                        if (res.data && res.data === 'success') {
                            this.$message({
                                type: 'success',
                                message: '删除成功'
                            })
                            this.showList()
                            this.updateDiaVisible = false
                        }
                    }).catch(() => {
                        this.$message({
                            type: 'info',
                            message: '删除失败'
                        })
                    })
                })
            },

        /*根据用户名查询*/
        searchByName (name) {

        },
        /*分页操作*/
        // 设置当前页面数据，对数组操作的截取规则为[0~9],[10~20]...,
        // 当currentPage为1时，我们显示(0*pageSize+1)-1*pageSize，当currentPage为2时，我们显示(1*pageSize+1)-2*pageSize...
        getCurrentPageData () {
            let begin = (this.currentPage - 1) * this.pageSize
            let end = this.currentPage * this.pageSize
            this.currentPageData = this.tableData.slice(
                begin,
                end
            )
        },
        //上一页
        prevPage () {
            console.log(this.currentPage)
            if (this.currentPage === 1) {
                return false
            } else {
                this.currentPage--
                this.getCurrentPageData()
            }
        },
        // 下一页
        nextPage () {
            if (this.currentPage === this.totalPage) {
                return false
            } else {
                this.currentPage++
                this.getCurrentPageData()
            }
        },
        /*跳转*/
        turn (currentPage) {
            let begin = (currentPage - 1) * this.pageSize
            let end = currentPage * this.pageSize
            this.currentPageData = this.tableData.slice(
                begin,
                end
            )
        },
    }
    ,
    components: {
    }
    }
</script>

<style>

</style>
