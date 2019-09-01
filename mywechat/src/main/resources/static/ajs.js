$(function () {


        // console.log(moment($("#endTime").val()).format('YYYY-MM-DD HH:mm:ss')>
        //     moment($("#endTime2").val()).format('YYYY-MM-DD HH:mm:ss'));
        // if(moment($("#endTime").val()).format('YYYY-MM-DD HH:mm:ss')>
        //     moment($("#endTime2").val()).format('YYYY-MM-DD HH:mm:ss')){
        //     alert("true");
        // };
b();

});

function as() {
    var time=$("#endTime2").val().trim();
    alert(time+typeof  time);
    alert(moment(time).format('YYYY-MM-DD HH:mm:ss'));
    alert(typeof moment(time).format('YYYY-MM-DD HH:mm:ss'))
}

function b() {
  // alert(moment().month(moment().month() - 1).startOf('month').format('YYYY-MM-DD HH:mm:ss'));
  //   alert(moment().month(moment().month() - 1).endOf('month').format('YYYY-MM-DD HH:mm:ss'));

        var a ="2018-12-31 23:59:59";
        var b="2018-12-31 23:59:59";
   alert( moment(a).month(moment(a).month() - 1).startOf('month').format('YYYY-MM-DD HH:mm:ss'));
    alert( moment(a).month(moment(a).month() - 1).endOf('month').format('YYYY-MM-DD HH:mm:ss'));

// alert(moment("2019-01-01 15:21"));
// alert(moment("2019-01-02 15:22"));
// alert(moment("2019-01-01 15:21")>moment("2019-01-02 15:22"));

}
