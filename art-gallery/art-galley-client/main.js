////////////////////////////////////////////////////////////////////////////////
//                                SHOPS                                       //
////////////////////////////////////////////////////////////////////////////////

//-------------------------------- ADD NEW SHOP --------------------------------

function addShop()
{
  var name = document.getElementById('name').value;
  var maxStorage = document.getElementById('maxStorage').value;

  var url = 'http://localhost:8080/shops';
  var dataBody = JSON.stringify({"name":name,"maxStorage":maxStorage});

  $.ajax(
  {
    type:'POST',
    url: url,
    contentType: "application/json",
    dataType: JSON,
    data: dataBody, 

    success: function(result)
    {
      console.log(result);
    },
    
    error: function(error)
    {
      alert(error);
    }

  });

  console.log("addShop() process done")
}

//-------------------------------- GET ALL SHOPS --------------------------------

function getShops()
{
  $.ajax(
  {
    type:'GET',
    url: "http://localhost:8080/shops",
    
    success: function(result)
    {
      console.log(result)
      
      // Process to create a table with the data
      var myShops = result
      var col = [];
      
      for (var i = 0; i < myShops.length; i++) 
      {
        for (var key in myShops[i]) 
        {
          if (col.indexOf(key) === -1) 
          {
            col.push(key);
          }
        }
      }
      
      var table = document.createElement("table");  
      var tr = table.insertRow(-1);
        for (var i = 0; i < col.length; i++) 
        {
          var th = document.createElement("th");
          th.innerHTML = col[i];
          tr.appendChild(th);
        } 
        for (var i = 0; i < myShops.length; i++) 
        {
          tr = table.insertRow(-1);
          for (var j = 0; j < col.length; j++) 
          {
            var tabCell = tr.insertCell(-1);
            tabCell.innerHTML = myShops[i][col[j]];
          }
        } 
        var divContainer = document.getElementById("showData");
        divContainer.innerHTML = "";
        divContainer.appendChild(table);
    },
    
    error: function(error)
    {
      alert(error);
    }
  
  });
  
  console.log("getShops() process done")

}

//-------------------------------- DELETE ALL SHOPS OF THE DATABASE --------------------------------

function deleteShops()
{
  $.ajax(
  {
    type:'DELETE',
    url: "http://localhost:8080/shops",
  });
  
  console.log("deleteShop() process done")

}

////////////////////////////////////////////////////////////////////////////////
//                               PICTURES                                     //
////////////////////////////////////////////////////////////////////////////////

//-------------------------------- SELECT SHOP ---------------------------------

$.ajax(
{
  type:'GET',
  url: "http://localhost:8080/shops",
  
  success: function(result)
  {
    var shopDataName = result;
    var dropdown = document.getElementById("selectShop");

    for (var i = 0; i < shopDataName.length; i++) 
    {
      var option = document.createElement("OPTION");

      option.innerHTML = shopDataName[i].name; //Set Customer Name in Text part.
      option.value = shopDataName[i].idShop; //Set CustomerId in Value part.
      dropdown.options.add(option); //Add the Option element to DropDownList.
    }
  },
  
  error: function(error)
  {
    alert(error);
  }

});

/* -----> funtion for testing "select shop"
function test(){
  var dropdown = document.getElementById("selectShop");
  alert(dropdown.value)
}
*/

//-------------------------------- ADD NEW PICTURE ---------------------------------

function addPicture()
{
  var author = document.getElementById('author').value;
  var title = document.getElementById('title').value;
  var price = document.getElementById('price').value;
  var idShop = document.getElementById("selectShop").value;

  var url = 'http://localhost:8080/shops/'+idShop+'/pictures';
  var dataBody = JSON.stringify({"author":author,"title":title,"price":price, "idShop": idShop});

  $.ajax(
  {
    type:'POST',
    url: url,
    contentType: "application/json",
    dataType: JSON,
    data: dataBody,  
    
    success: function(result)
    {
      console.log(result);
    },
    
    error: function(error)
    {
      alert(error);
    }
  
  });

  console.log("addPicture() process done")

}


//-------------------------------- GET PICTURE FROM ONE SHOP ---------------------------------

// SELECT THE SHOP 
$.ajax( 
  {
    type:'GET',
    url: "http://localhost:8080/shops",
    
    success: function(result)
    {
      var shopDataName = result;
      var dropdown = document.getElementById("selectShop2");
  
      for (var i = 0; i < shopDataName.length; i++) 
      {
        var option = document.createElement("OPTION");
  
        option.innerHTML = shopDataName[i].name; //Set Customer Name in Text part.
        option.value = shopDataName[i].idShop; //Set CustomerId in Value part.
        dropdown.options.add(option); //Add the Option element to DropDownList.
      }
    },
    
    error: function(error)
    {
      alert(error);
    }
  
  });

function getPictures() 
{
  var idShop = document.getElementById("selectShop").value;
  var url = 'http://localhost:8080/shops/'+ idShop +'/pictures';

  $.ajax(
  {
    type:'GET',
    url: url,

    success: function(result)
    {
      var pictures = result
      var col = [];
        for (var i = 0; i < pictures.length; i++) 
        {
          for (var key in pictures[i]) 
          {
            if (col.indexOf(key) === -1) 
            {
              col.push(key);
            }
          }
        }
      var table = document.createElement("table");  
      var tr = table.insertRow(-1);
        for (var i = 0; i < col.length; i++) 
        {
          var th = document.createElement("th");
          th.innerHTML = col[i];
          tr.appendChild(th);
        } 
        for (var i = 0; i < pictures.length; i++) 
        {
          tr = table.insertRow(-1);
          for (var j = 0; j < col.length; j++) 
          {
            var tabCell = tr.insertCell(-1);
            tabCell.innerHTML = pictures[i][col[j]];
          }
        } 
        var divContainer = document.getElementById("showData2");
        divContainer.innerHTML = "";
        divContainer.appendChild(table);
    },

    error: function(error)
    {
      alert(error);
    }

  });

  console.log("getPictures() process done")

}