$(document).ready(function(){
    $('#navbar-collapse .dropdown-menu a').click(function(){
   let href=$(this).attr('href');
    $("#tab-list a[href='"+href	+"']").tab("show");
     }); 
})
//登录功能
function doLogin(){
$.post("login",$('#loginForm').serialize(),function(data){
	if(data==true){
		alert("登录成功!");
		//location="index.html";
		$(".navbar-right").hide();
		$("#wel").show();
		$("#loginoutBtn").show();
	}else{
		alert("登录失败！");
		//location="index.html";
	}
   })
}
 

//时间轴功能

var num = GetRandomNum(0,url.length-1);   
function GetRandomNum(Min,Max)
{
var Range = Max - Min;   
var Rand = Math.random();   
return(Min + Math.round(Rand * Range));   
}   

function play(){
var div = document.getElementById('playbtn'); 
var obj=document.getElementById("audios");
if(obj.paused){
obj.play();
div.setAttribute("class", "btn_sound"); 
}else{
obj.pause();
div.setAttribute("class", "btn_sound btn_no_sound"); 
}

}
//家族树功能
$(function() { 
    $('.tree li:has(ul)').addClass('parent_li').find(' > span').attr('title', 'Collapse this branch'); 
    $('.tree li.parent_li > span').on('click', function(e) { 
        var children = $(this).parent('li.parent_li').find(' > ul > li'); 
        if (children.is(":visible")) { 
            children.hide('fast'); 
            $(this).attr('title', 'Expand this branch').find(' > i').addClass('icon-plus-sign').removeClass('icon-minus-sign'); 
        } else { 
            children.show('fast'); 
            $(this).attr('title', 'Collapse this branch').find(' > i').addClass('icon-minus-sign').removeClass('icon-plus-sign'); 
        } 
        e.stopPropagation(); 
    }); 
});
	

	


//退出功能
function logout(){
         top.location = "index.html";     
}



