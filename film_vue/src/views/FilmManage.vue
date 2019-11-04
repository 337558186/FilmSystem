<template>
	<div>
		<template>
			<el-table
				:data="currentPageData/*.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))*/"
				style="width: 100%;line-height: 50px;"
				v-loading="isLoaded" element-loading-test="拼命加载中">
				<el-table-column
					label="ID"
					prop="filmId">
				</el-table-column>

				<el-table-column label="预览图" prop="image.imageUrl">
					<template   slot-scope="scope">
						<img :src="scope.row.image.imageUrl"  min-width="70" height="70" alt="图片预览"/>
					</template>
				</el-table-column>


				<el-table-column
					label="电影名称"
					prop="filmName">
				</el-table-column>

				<el-table-column
					label="导演"
					prop="director">
				</el-table-column>

				<el-table-column
					label="电影时长（分）"
					prop="duration">
				</el-table-column>

				<el-table-column
					label="电影价格（元）"
					prop="price">
				</el-table-column>

				<el-table-column
					label="上映时间"
					prop="date" :formatter="dateFormat" width="180px">
				</el-table-column>


				<el-table-column align="right">
					<template slot="header" slot-scope="scope">
						<el-input
							v-model="search"
							size="small"
							placeholder="输入电影名称" @keyup.enter="searchByName(search)"></el-input>
						<el-button @click="searchByName(search)">搜索</el-button>
					</template>

					<template slot-scope="scope">
						<el-button type="primary" round
								   size="mini "
								   @click="handleEdit(scope.$index, scope.row)">编辑
						</el-button>
						<el-button type="danger" round
								   size="mini "
								   @click="handleDelete(scope.$index, scope.row)">删除
						</el-button>
					</template>
				</el-table-column>
			</el-table>
		</template>
		<!--分页代码-->
		<div class="block">

			<!--<el-select v-model="pageSize" placeholder="每页显示" size="mini" style="width: 120px" @blur="show(pageSize)">
				<el-option>5条</el-option>
				<el-option>10条</el-option>
				<el-option>15条</el-option>
				<el-option>20条</el-option>
			</el-select>-->

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
		<el-dialog title="编辑电影信息" :visible.sync="updateDiaVisible">
			<el-form :model="selectedRow" size="mini" label-width="80px">
				<input type="hidden" name="id" :value="selectedRow.id"/><!--用隐藏域绑定id-->

				<el-form-item label="电影名称">
					<el-input v-model="selectedRow.filmName"></el-input>
				</el-form-item>

				<el-form-item label="导演">
					<el-input v-model="selectedRow.director"></el-input>
				</el-form-item>

				<el-form-item label="时长（分钟）">
					<el-input v-model="selectedRow.duration"></el-input>
				</el-form-item>
				<el-form-item label="价格(元)">
					<el-input v-model="selectedRow.price"></el-input>
				</el-form-item>

				<el-form-item label="上映时间" required>
					<el-col :span="11">
						<el-form-item prop="date">
							<el-date-picker type="date" placeholder="选择日期" v-model="selectedRow.date"
											style="width: 100%;"></el-date-picker>
						</el-form-item>
					</el-col>
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
    import {formatDate} from '../plugins/data'
    import moment from 'moment'  /*日期格式化*/
    export default {
        name: 'FilmManage',
        data () {
            return {
                search: '',
                tableData: [],  //所有数据
                totalPage: 0, // 统共页数，默认为1
                currentPage: 1, //当前页数 ，默认为1
                pageSize: 7, // 每页显示数量
                currentPageData: [],//当前页显示内容

                selectedRow: {
                    filmId: '',
                    filmName: '',
                    director: '',
                    duration: '',
                    price: '',
                    date: '',
                },
                updateDiaVisible: false,
                isLoaded: false,
            }
        },
        components: {},
        mounted () {
        },
        created () {
            this.showList();

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
                        this.isLoaded = false  /*结束读取动画*/
                    })
                    .catch((error) => {
                        console.log(error)//异常
                    })
                arr.axios.get('film/count')
                    .then((response) => {
                        console.log(response.data)//请求的返回体
                        // 计算一共有几页
                        this.totalPage = Math.ceil(response.data / this.pageSize)
                        console.log(this.totalPage)
                        this.getCurrentPageData()
                    })
                    .catch((error) => {
                        console.log(error)//异常
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

            /*编辑*/
            handleEdit (index, data) {
                console.log(data)
                //给selectedrow赋值
                this.selectedRow.filmId = data.filmId
                this.selectedRow.filmName = data.filmName
                this.selectedRow.director = data.director
                this.selectedRow.duration = data.duration
                this.selectedRow.price = data.price
                this.selectedRow.date = data.date
                //打开窗口
                this.updateDiaVisible = true
            },
            update () {
                this.axios.post('film/update', this.selectedRow).then(res => {
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
                console.log(index, data)

                this.$confirm('确认删除？', '警告', {
                    type: 'warning'
                }).then(() => {
                    this.axios.post('film/delete', {
                        filmId: data.filmId
                    }).then(res => {
                        if (res.data && res.data.status === 'success') {
                            this.$message({
                                type: 'success',
                                message: '删除成功'
                            })
                            this.showList()
                        }
                    })
                })
            },

            /*模糊查询*/
            searchByName (search) {
               // console.log(search)
                this.axios.post('film/getFilmByFilmName', {
                    filmName: search
                }).then(res => {
                    this.tableData = res.data
                    // 计算一共有几页
                    this.totalPage = Math.ceil(this.tableData.length / this.pageSize)
                    console.log(this.totalPage)
                    this.getCurrentPageData()

                }).catch((error) => {
                    console.log(error)//异常
                })

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
            /*每页显示*/
            show (size) {
                let begin = (this.currentPage - 1) * size
                let end = this.currentPage * size
                this.currentPageData = this.tableData.slice(
                    begin,
                    end
                )
            },
        },
    }
</script>

<style scoped>
	.el-table_1_column_7 {
		width: 180px
	}
</style>
