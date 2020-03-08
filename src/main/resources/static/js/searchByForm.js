
    $(document).ready(function() {

//    function  getData (){
//     var form = document.getElementById("searchForm");
//                var inputTagElements = form.getElementsByTagName('input');
//                var dataString = "{"
//                for (var j = 0; j < inputTagElements.length; j++) {
//                dataString+='"'+inputTagElements[j].id+'":"'+inputTagElements[j].value+'",';
//
//                }
//                dataString = dataString.substr(0, dataString.length - 1);
//                dataString+='}';
//                var data =  $.parseJSON( dataString );
//
//                return data;
//    }





//
                 var table = $('#example').DataTable({
                 stateSave: true
//                   'ajax': {
//                     "type"   : "get",
//                     "url"    : '/flexiCaputreStatus/test',
//                     "data"   : function( d ) {
//                           d.invoiceNumber= $('#invoiceNumber').val();
//                           d.supplierNumber= $('#supplierNumber').val();
//                           d.customerNumber= $('#customerNumber').val();
//                            d.amount= $('#amount').val();
//                         },
//                     "dataType": "JSON",
//                     "dataSrc": "tableData"
//                   },
//                   'columns': [
//                     {"data" : "supplierId"},
//                     {"data" : "invoiceId"},
//                     {"data" : "url"}
//                   ]
                 });


     $('#submitButton').on('click',  function () {

          var form = document.getElementById("searchForm");
                     var inputTagElements = form.getElementsByTagName('input');
                     var dataString = "{"
                     for (var j = 0; j < inputTagElements.length; j++) {
                     dataString+='"'+inputTagElements[j].id+'":"'+inputTagElements[j].value+'",';

                     }
                     dataString = dataString.substr(0, dataString.length - 1);
                     dataString+='}';
                     var data =  $.parseJSON( dataString );



                     $.ajax({
                            type: "get",
                            url: "/flexiCaputreStatus/test",
                           // data: { page: $("#page").val(), limit: 5 },
                           data: data,
                            dataType: "JSON",
                            success: function(result) {
                           console.log("======>"+result);

                           for(var i =0 ; i <result.tableData.length;i++){
                            var temp = result.tableData[i];
                            table.row.add( [
                                       temp.supplierId,
                                       temp.invoiceId,
                                       temp.url

                                   ] ).draw( false );
                           }


                            }
                          });



     // console.log(table.ajax.data);

    //table.ajax.reload();






//        $.ajax({
//                        type:'POST',
//                        url:'/flexiCaputreStatus/search',
//                        data:formData,
//                        dataType:"json",
//                        success:function(data){
//                            console.log(data);
//                           var err_code=data.err_code;
//                           alert(data.msg);
//                        }
//                    })






//


    } );
//
//    $('#invoiceTable').dataTable( {
//      "ajax": {
//        "url": "data.json",
//        "dataSrc": "tableData"
//      }
//    //假设传回的集合是{tableData:[{...},{...}],page:{...},...}
//    } );









} );

