<template>
  <div>
      <h1>注册</h1>
      <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
        <el-form-item label="用户名" prop="username">
            <el-input type="text" v-model="ruleForm.username" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
            <el-input type="password" v-model="ruleForm.password" autocomplete="off"></el-input>
        </el-form-item>

        <el-form-item label="确认密码" prop="checkPass">
            <el-input type="password" v-model="ruleForm.checkPass" autocomplete="off"></el-input>
        </el-form-item>

        <el-form-item label="手机号码" prop="phone">
             <el-input type="text" v-model="ruleForm.phone" autocomplete="off"></el-input>
         </el-form-item>

         <el-form-item>
            <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
            <el-button @click="resetForm('ruleForm')">重置</el-button>
         </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  data() {
      var validateUsername=(rule,value,callback) =>{
          if(value ===''){
              callback(new Error('请输入用户名'));
          }else{
          callback();
        }
      };
      var validatePass = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入密码'));
        } else {
          if (this.ruleForm.checkPass !== '') {
            this.$refs.ruleForm.validateField('checkPass');
          }
          callback();
        }
      };
      var validatePass2 = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请再次输入密码'));
        } else if (value !== this.ruleForm.password) {
          callback(new Error('两次输入密码不一致!'));
        } else {
          callback();
        }
      };

     var validateMobilePhone = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入手机号'));
        } else {
          if (value !== '') {
            var reg=/^1[3456789]\d{9}$/;
            if(!reg.test(value)){
              callback(new Error('请输入有效的手机号码'));
            }
          }
          callback();
        }
      };

    return {
        ruleForm: {
          username: '',
          password: '',
          checkPass: '',
          phone: ''
        },
        rules: {
            username:[
                { validator: validateUsername, trigger: 'blur' }
            ],
            password: [
                { validator: validatePass, trigger: 'blur' }
            ],
            checkPass: [
                { validator: validatePass2, trigger: 'blur' }
            ],
            phone: [
                { validator: validateMobilePhone, trigger: 'blur' }
            ]
        }
    }
  },
  methods: {
      submitForm(formName) {
        this.axios.post("user/registered", {userName:this.ruleForm.username,password:this.ruleForm.password,phone:this.ruleForm.phone}).then(res => {
			console.log(res.data);
			if(res.data === 1){
				alert('注册成功');
             	this.$router.replace("/");
			}else{
				alert("注册失败")
			}
          }).catch(error => {
            alert('注册失败');
            console.log(error);
          });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }

  },
  components: {

  }
}
</script>

<style>

</style>
