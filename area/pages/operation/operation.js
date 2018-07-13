// pages/operation/operation.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    areaId: undefined,
    areaName: "",
    priority: "",
    addUrl: "http://127.0.0.1:8082/wechatApp/area/saveArea",
    updateUrl: "http://127.0.0.1:8082/wechatApp/area/updateArea",
    typeNumber:0
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    
    if (options.areaId == undefined) {     //表示是点击添加区域信息来到的这个页面
      this.setData({
        typeNumber: 1,
      });
      return;
    }

    this.setData({
      areaId: options.areaId,        //options.areaId表示从list页面传过来的areaId的值
      typeNumber: 0
    });
    /**
     * 通过areaId查询区域信息
     */
    wx.request({
      url: "http://127.0.0.1:8082/wechatApp/area/getAreaById",
      data: { "areaId": options.areaId},
      method: "GET",
      success: function(res){
        var area = res.data;
        if(area == undefined){
          var toastText = "获取数据失败...";
          wx.showToast({
            title: toastText,
            icon: "",
            duration: 2000
          })
        }else{
          that.setData({
            areaName: area.areaName,
            priority: area.priority,
          });
        }
      }
    })
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
  
  },

  goBack: function(){
    wx.redirectTo({
      url: "../list/list",
    })
  },

  formSubmit: function(e){
    var that = this;
    var formData = e.detail.value;    //获取form表单的数据
    var url = that.data.addUrl;
    if(that.data.areaId != undefined){    //表示这次是update操作
      formData.areaId = that.data.areaId;
      url = that.data.updateUrl;
    }
    wx.request({
      url: url,
      data: JSON.stringify(formData),
      method: "POST",
      header: {
        "Content-Type": "application/json"
      },
      success: function(res){
        var result = res.data;
        var toastText = "操作成功...";
        if(result != "success"){
          toastText = "操作失败...";
        }
        wx.showToast({
          title: toastText,
          icon: "",
          duration: 2000
        });
        /**
         * 如果是添加操作，在添加成功之后，返回到list页面
         */
        if(that.data.areaId == undefined){    
          wx.redirectTo({
            url: "../list/list",
          })
        }
      }
    })
  }
})