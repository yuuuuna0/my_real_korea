import * as View from "./view.js";
import * as Request from "./request.js";
// JSON.stringify() => 객체를 string 으로, JSON.parse() => string 을 객체로 만듦

/********* function *********/
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


$(document).on('show.bs.modal','#myReviewModal',function(){
    let userId=$('#myReviewBtn').data('id');
    $('#myReviewModal').find('#userId').val(userId);
});

$(document).on('click','#submitReviewBtn',function(){
    let url="ticket-review-action";
    let method="POST";
    let contentType="application/json;charset=UTF-8";
    let sendData=[];
    let async=true;
    
    console.log(sendData);

    Request.ajaxRequest(url,method,contentType,
        JSON.stringify(sendData),
        function(resultJson){
			
			console.log(resultJson);

            if(resultJson.code==1){
                View.render('#ticketReview-template',resultJson,'#ticketReviewDiv')
            } else{
                alert(resultJson.msg);
            }
        },async);
});
