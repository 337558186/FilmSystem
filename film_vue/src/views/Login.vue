<template>
	<div id="logo">
		<div class="login-box" style="margin-top:200px">
			<!-- 通过:rules="loginFormRules"来绑定输入内容的校验规则 -->
			<el-form :rules="loginFormRules" ref="loginForm" :model="loginForm" label-position="right"
					 label-width="auto"
					 show-message>
				<span class="login-title" style="margin-left:-110px;font-size:30px">欢迎登录</span>

				<div style="margin-top: 5px"></div>

				<el-form-item label="用户名" prop="loginName" style="margin-left:500px;margin-top:30px;font-weight:bold">
					<el-col :span="8">
						<el-input type="text" v-model="loginForm.loginName"></el-input>
					</el-col>
				</el-form-item>

				<el-form-item label="密码" prop="loginPassword" style="margin-left:500px;font-weight:bold">
					<el-col :span="8">
						<el-input type="password" v-model="loginForm.loginPassword" @keyup.enter="login"></el-input>
					</el-col>
				</el-form-item>
				<el-form-item>
					<el-button type="primary" @click="login" style="margin-left:-180px">登录</el-button>&nbsp;&nbsp;&nbsp;&nbsp;
					<el-button type="primary" @click="onRegit" style="margin-left:-280px">注册</el-button>
				</el-form-item>
			</el-form>
		</div>
	</div>
</template>

<script>
    import {mapState} from 'vuex'

    export default {
        name: 'login',
        data () {
            return {
                loginForm: {
                    loginName: '',
                    loginPassword: ''
                },
                // 表单验证，需要在 el-form-item 元素中增加 prop 属性
                loginFormRules: {
                    loginName: [
                        {required: true, message: '账号不可为空', trigger: 'blur'}
                    ],
                    loginPassword: [
                        {required: true, message: '密码不可为空', trigger: 'blur'}
                    ]
                }
            }
        },
        created () {
            /*键盘事件*/
            var lett = this
            document.onkeydown = function (e) {
                var key = window.event.keyCode
                if (key === 13) {
                    lett.login()
                }
            }
        },
        methods: {
            login () {
                /* let _this = this;*/
                this.axios.post('user/login', {
                    userName: this.loginForm.loginName,
                    password: this.loginForm.loginPassword
                }).then(res => {
                    console.log(res.data.userName)
                    this.$store.commit('handleUser', res.data)  /*存至vuex  主页展示用户*/
                    sessionStorage['username'] = this.loginForm.loginName   /*登录拦截*/
					console.log(res.data.roleId)
					if(res.data.roleId ===2 || res.data.roleId ===3){
                        this.$router.replace('/index/welcome')
					}else{
                        this.$router.replace('/findex/welcome')
					}

                }).catch(error => {
                    alert('账号或密码错误')
                    console.log(error)
                })
            },
            onRegit () {
                this.$router.push({path: '/registered'})
            }
        }
    }
</script>
<style scoped>
	#logo {
		background: url("../assets/login.jpg");
		position: fixed;
		top: 0;
		left: 0;
		width: 100%;
		height: 100%;
		min-width: 1000px;
		z-index: -10;
		zoom: 1;
		background-color: #fff;
		background-repeat: no-repeat;
		background-size: cover;
		-webkit-background-size: cover;
		-o-background-size: cover;
		background-position: center 0;
	}
</style>

