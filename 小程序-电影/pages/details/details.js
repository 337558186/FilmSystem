// pages/details/details.js
Page({

    /**
     * 页面的初始数据
     */
    data: {
        videoInfo: null
    },
    /*根据ID获取视频详情*/
    getDetail(_filmId){
        let arr = this;
        console.log(_filmId.id)
        wx.request({
            url: "http://localhost:8080/film/getFilmById1",
            method: 'post',
             data: {
                 filmId: _filmId.id
             },
            header: {
                "Content-Type": "application/x-www-form-urlencoded"
            },
             success(res){
                console.log(res)
                if (res.data!=null) {
                    arr.setData({
                        videoInfo:res.data
                    })
                  }
             }
        })

    },





    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function (options) {
        // console.log(options)   获取传递的用户名
        let filmId = options;
        this.getDetail(filmId);

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