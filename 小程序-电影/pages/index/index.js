Page({

  /**
   * 页面的初始数据
   */
  data: {
    /*导航栏的电影类别*/
    navList: [],
    /*当前选中的菜单栏的索引*/
    currentIndexNav:0,
    // 轮播图  最近更新电影
    swiperList: [],
    // 视频列表
    filmList: [],
  },

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

/*获得最近更新电影--轮播图*/
getSwiper(){
    let arr = this;
    wx.request({
      url:"http://localhost:8080/film/lastUpdated",
      success(res){
       // console.log(res);
        if(res.data.length>0){
            arr.setData({
              swiperList:res.data
            })
        }
      }
    })
},
/*获取视频列表*/
getFilmList(){
     let arr = this;
     wx.request({
        url:"http://localhost:8080/film/listFilm",
        success(res){
          console.log(res);
          if(res.data.length>0){
            arr.setData({
              filmList:res.data
            })
          }
        }
     })
},


  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    /*获取电影分类信息*/
    this.getType();
    // 轮播图
    this.getSwiper();
    //获取全部电影
    this.getFilmList();
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
    
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {
    
  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {
    
  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {
    
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
    
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {
    
  }
})