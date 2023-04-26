/**
 * view.js
  화면 일부분을 템플릿으로 변경할 때 쓰는 공용 클래스
 */
 
export function render(templateId, jsonResult={}, contentId){
	
	let templateHtml = $(templateId).html(); // id로 메인페이지 화면의 html 얻기
	let bindTemplate = Handlebars.compile(templateHtml);
	
	/*************** Handlebars 함수 등록 *******************
	Handlebars.registerHelper('substring', function(str, start, end){
		return str.substring(start, end);
	});
	********************************************************/
	// 날짜 출력 형태 yyyy-mm-dd 함수 
	Handlebars.registerHelper('dateFormat', function(dateString) {
	  var date = new Date(dateString);
	  return date.toLocaleDateString('ko-KR', { year: 'numeric', month: '2-digit', day: '2-digit' });
	});
	Handlebars.registerHelper('dateFormat2', function(dateString) {
	  var date = new Date(dateString);
	  return date.toLocaleDateString('ko-KR', { month: '2-digit', day: '2-digit' });
	});
	Handlebars.registerHelper('dateFormat3', function(dateString) {
 	  var date = new Date(dateString);
	  var year = date.getFullYear();
	  var month = ('0' + (date.getMonth() + 1)).slice(-2);
	  var day = ('0' + date.getDate()).slice(-2);
	  return year + '년 ' + month + '월 ' + day + '일';
});

	
	//if함수 (if else 아님)
	Handlebars.registerHelper('ifCond',function(v1,operator,v2,options){
		switch(operator){
			case '!=':
				 return (v1 != v2) ? options.fn(this) : options.inverse(this);
			case '==':
        	    return (v1 == v2) ? options.fn(this) : options.inverse(this);
        	case '===':
        	    return (v1 === v2) ? options.fn(this) : options.inverse(this);
        	case '<':
        	    return (v1 < v2) ? options.fn(this) : options.inverse(this);
        	case '<=':
        	    return (v1 <= v2) ? options.fn(this) : options.inverse(this);
       		case '>':
        	    return (v1 > v2) ? options.fn(this) : options.inverse(this);
       		case '>=':
            	return (v1 >= v2) ? options.fn(this) : options.inverse(this);
        	case '&&':
            	return (v1 && v2) ? options.fn(this) : options.inverse(this);
        	case '||':
            	return (v1 || v2) ? options.fn(this) : options.inverse(this);
        	default:
            	return options.inverse(this);
		}
	});
	//별찍기
	Handlebars.registerHelper('generateStarHtml',function(count){
		let html='';
		if(count==0){
			for(let i=0;i<5;i++) {
 				html += "<i class='icon-star-empty'></i>&nbsp";
			}
		}else if(count==5){
			for(let i=0;i<5;i++) {
 				html += "<i class='icon-star voted'></i>&nbsp";
			}
		}else{
			for(let i=0;i<count;i++) {
 				html += "<i class='icon-star voted'></i>&nbsp";
			}
			for(let i=count;i<5;i++) {
 				html += "<i class='icon-star-empty'></i>&nbsp";
			}
		}
		return new Handlebars.SafeString(html);
	});
	
	//for문
	Handlebars.registerHelper('numSequence', function(start, end) {
  		let result = '';
  		let divideEnd=Math.ceil(end/9);
	  		for (let i = start; i <=divideEnd; i++) {
	    		result += this.fn(i);
	  		}
 		 return result;
	});
	
	let resultTemplate = bindTemplate(jsonResult); // {}에 JSON객체/JSON Array 넣어줌 => 메인페이지 화면 + JSON 데이터 합친 결과 = resultTemplate
	$(contentId).html(resultTemplate); // content 부분에 resultTemplate 넣기
	
}