var arr=[];
var arr2=["adcs","123b","123","ssafsa"];
arr.push("123");
arr.push("adcs");
arr.push("a123");
arr.push("123b");
var flag= true;
for(var i in arr){
    if(arr2.indexOf(arr[i])<0){
        flag=false;
    }
}
if(flag){
    alert("true");
}else{
    alert("false");
}