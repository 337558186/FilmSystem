// components/menu/menu.js
Component({
    /**
     * 组件的属性列表
     */
    properties: {

    },

    /**
     * 组件的初始数据
     */
    data: {
        /*导航栏的电影类别*/
        navList: [],
        /*当前选中的菜单栏的索引*/
        currentIndexNav:1,
    },

    /**
     * 组件的方法列表
     */
    methods: {
        /*点击导航菜单*/
        activeNav(e){

            this.setData({
                currentIndexNav: e.target.dataset.index
            })
        },

        /*发送请求获得电影分类*/
        getType(){
        let arr = this;
        wx.request({
            url: "http://localhost:8080/type/typeList",
            success(res){
                //console.log(res);
                if (res.data.length>0) {
                arr.setData({
                    navList:res.data
                })
                }
            }
        })
        },

    }
})
