<template>
	<div>
		<h2 style="line-height: 80px;">添加新的电影</h2>
		<div style="margin: 20px;"></div>
		<el-form :label-position="labelPosition" label-width="80px" :model="formLabelAlign">

			<el-form-item label="电影名称">
				<el-input v-model="formLabelAlign.filmName"></el-input>
			</el-form-item>

			<el-form-item label="导演">
				<el-input v-model="formLabelAlign.director"></el-input>
			</el-form-item>

			<el-form-item label="电影时长">
				<el-input v-model="formLabelAlign.duration"></el-input>
			</el-form-item>

			<el-form-item label="电影价格">
				<el-input v-model="formLabelAlign.price"></el-input>
			</el-form-item>

			<el-form-item label="上映时间" required>
				<el-col :span="11">
					<el-form-item prop="date">
						<el-date-picker type="date" placeholder="选择日期" v-model="formLabelAlign.date"
										style="width: 100%;"></el-date-picker>
					</el-form-item>
				</el-col>
			</el-form-item>

			<!--文件上传-->
			<div style="margin-left: -900px;line-height: 50px">
				<el-upload
					action="http://localhost:8080/image/upload"
					list-type="picture-card"
					:on-success="handleAvatarSuccess"
					:on-preview="handlePictureCardPreview"
					:on-remove="handleRemove">
					<i class="el-icon-plus"></i>
				</el-upload>
				<el-dialog :visible.sync="dialogVisible">
					<img width="100%" :src="dialogImageUrl" alt="">
				</el-dialog>
			</div>


			<el-form-item >
				<el-button type="success" @click="addFilm" >提交</el-button>
			</el-form-item>

		</el-form>
	</div>
</template>

<script>
    export default {
        name: 'AddFilm',
        data () {
            return {
                labelPosition: 'right',
                formLabelAlign: {
                    filmName: '',
                    director: '',
                    duration: '',
                    date: '',
                    price: '',
                    image: {
                        imageId: '',
                        imageUrl: ''
                    },
                },
			/*文件上传*/
                dialogImageUrl: '',
                dialogVisible: false
            }
        },
        created () {
        },
        methods: {
            addFilm () {
                this.axios.post('film/insertFilm', {
                    filmName: this.formLabelAlign.filmName,
                    director: this.formLabelAlign.loginPassword,
                    duration: this.formLabelAlign.duration,
                    date: this.formLabelAlign.date,
                    price: this.formLabelAlign.price,
                    imageId: this.formLabelAlign.image.imageId
                }).then( res =>{
                    console.log(res.data)
                    if(res.data && res.data==='success'){
                        this.$message({
                            type:"success",
                            message:'添加成功'
                        })
                    }
				}).catch( () => {
                    this.$message({
                        type:"info",
                        message:'添加失败'
                    })
                })
            },
            /*文件上传*/
            handleAvatarSuccess(response, file, fileList) {
                console.log(response)
                this.formLabelAlign.image.imageId = response;
            },
            handleRemove(file, fileList) {
                this.$alert(`确定移除该文件？`, '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    this.deleteFile(file, fileList)
                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: '取消删除操作'
                    })
                })
                return false
            },
            handlePictureCardPreview(file) {
                this.dialogImageUrl = file.url;
                this.dialogVisible = true;
            }
        }
    }
</script>

<style scoped>

</style>
