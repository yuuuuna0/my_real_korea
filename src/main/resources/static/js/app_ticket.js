import * as View from "./view.js";
import * as Request from "./request.js";
// JSON.stringify() => 객체를 string 으로, JSON.parse() => string 을 객체로 만듦

/********* function ********/
function selectedTicketList(){
    let keyword=$('#ticket-search-keyword').val();
    let cityNo;
    let sortOrder=$('#ticket-sort').val();

    if($('#city-checkbox:checked').length==1){
        cityNo=$('#city-checkbox:checked').val();
    } else{
        cityNo=0;
    }

    let url= 'ticket-list-sort';
    let method='POST';
    let contentType="application/json;charset=UTF-8";
    let sendData={
        currentPage:"1",
        keyword:keyword,
        cityNo:cityNo,
        sortOrder:sortOrder
    };
    let async=true;

    Request.ajaxRequest(url,method,contentType,
        JSON.stringify(sendData),
        function(resultJson){
            //code=1 성공 -> render , 아닐때 msg
            if(resultJson.code==1){
                View.render('#ticket-search-list-template',resultJson,'#ticket-list')
            } else{
                alert(resultJson.msg);
            }
        },async);
};


$(document).on('change',$('#ticket-sort,#city-checkbox'),selectedTicketList);
$(document).on('click',"#ticket-search-btn",selectedTicketList);


$('input[type="checkbox"][name="city-checkbox"]').click(function(){
    if($(this).prop('checked')){
        $('input[type="checkbox"][name="city-checkbox"]').prop('checked',false);
        $(this).prop('checked',true);
    }
});


$(document).on('show.bs.modal','#myReview',function(){
    let loginUser=$('#myReviewBtn').data('id');
    let tiNo=$('#myReviewBtn').data('tino');
    $('#myReview').find('#userId').val(loginUser);
    $('#myReview').find('#hiddenTiNo').val(tiNo);
    console.log(loginUser); // id....
    console.log(tiNo);
});

$('#ticket-review-action').click(function(e){
	  let sendData={
					tiNo:$('#hiddenTiNo').val(), // 임의
					tiReviewTitle:document.ticketReview.tiReviewTitle.value,
					tiReviewStar:document.ticketReview.tiReviewStar.value,
					tiReviewContent:document.ticketReview.tiReviewContent.value,
					tiReviewImg:'어쩌구.jpg', // 임의
					userId:document.ticketReview.userId.value
					};
					console.log($('#hiddenTiNo').val());
		/*url,mehtod,contentType,sendData,callbakc,async*/
	    Request.ajaxRequest('ticket-review-action',
	    					'POST',
	    					'application/json;charset=UTF-8',
		       				 JSON.stringify(sendData),
		       				 function(resultJson){
							let tiNo = $('#hiddenTiNo').val();
		           		 		if(resultJson.code==1){
			window.location.href=`ticket-detail?tiNo=${tiNo}`;
			/*아이디값? */
		          			  } else{
		               				 alert(resultJson.msg);
		            }
		            }
		            ,true);
        e.preventDefault();
});
