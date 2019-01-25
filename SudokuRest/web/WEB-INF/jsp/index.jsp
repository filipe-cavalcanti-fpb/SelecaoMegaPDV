<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>HTML Sudoku Board</title>

    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">

    <style type="text/css">

      html, body {
        background-color: #ffffff
      }

      table {
        border: 2px solid #000000;
      }


      input {
        color: #000000;
        padding: 0;
        border: 0;
        text-align: center;
        width: 48px;
        height: 48px;
        font-size: 24px;
        background-color: #FFFFFF;
        outline: none;
      }


    </style>
  </head>
  <body>

    <div class="container">

      <h1 class="title">Sudoku CSP</h1>
      <div class="row">
        <div class="col-lg-6">
          <table id="grid" class="table-bordered">

          <tr>
            <td><input class="sudoku-cell" min="1" max="9" id="0"  type="text"></td>
            <td><input class="sudoku-cell" min="1" max="9" id="1"  type="number" ></td>
            <td><input class="sudoku-cell" min="1" max="9" id="2"  type="number"></td>
            <td><input class="sudoku-cell" min="1" max="9" id="3" type="number"></td>
            <td><input class="sudoku-cell" min="1" max="9" id="4"  type="number" ></td>
            <td><input class="sudoku-cell" min="1" max="9" id="5"  type="number"></td>
            <td><input class="sudoku-cell" min="1" max="9" id="6"  type="number"></td>
            <td><input class="sudoku-cell" min="1" max="9" id="7"  type="number"></td>
            <td><input class="sudoku-cell" min="1" max="9" id="8"  type="number"></td>
          </tr>

          <tr>
            <td><input class="sudoku-cell" min="1" max="9" id="9"  type="number"></td>
            <td><input class="sudoku-cell" min="1" max="9" id="10" type="number"></td>
            <td><input class="sudoku-cell" min="1" max="9" id="11" type="number"></td>

            <td><input class="sudoku-cell" min="1" max="9" id="12" type="number" ></td>
            <td><input class="sudoku-cell" min="1" max="9" id="13" type="number" ></td>
            <td><input class="sudoku-cell" min="1" max="9" id="14" type="number" ></td>

            <td><input class="sudoku-cell" min="1" max="9" id="15" type="number"></td>
            <td><input class="sudoku-cell" min="1" max="9" id="16" type="number"></td>
            <td><input class="sudoku-cell" min="1" max="9" id="17" type="number"></td>
          </tr>

          <tr>
            <td><input class="sudoku-cell" min="1" max="9" id="18" type="number"></td>
            <td><input class="sudoku-cell" min="1" max="9" id="19" type="number" ></td>
            <td><input class="sudoku-cell" min="1" max="9" id="20" type="number"></td>

            <td><input class="sudoku-cell" min="1" max="9" id="21" type="number"></td>
            <td><input class="sudoku-cell" min="1" max="9" id="22" type="number"></td>
            <td><input class="sudoku-cell" min="1" max="9" id="23" type="number"></td>

            <td><input class="sudoku-cell" min="1" max="9" id="24" type="number"></td>
            <td><input class="sudoku-cell" min="1" max="9" id="25" type="number" ></td>
            <td><input class="sudoku-cell" min="1" max="9" id="26" type="number"></td>
          </tr>

          <tr>
            <td><input class="sudoku-cell" min="1" max="9" id="27" type="number"></td>
            <td><input class="sudoku-cell" min="1" max="9" id="28" type="number"></td>
            <td><input class="sudoku-cell" min="1" max="9" id="29" type="number"></td>

            <td><input class="sudoku-cell" min="1" max="9" id="30" type="number"></td>
            <td><input class="sudoku-cell" min="1" max="9" id="31" type="number"></td>
            <td><input class="sudoku-cell" min="1" max="9" id="32" type="number"></td>

            <td><input class="sudoku-cell" min="1" max="9" id="33" type="number"></td>
            <td><input class="sudoku-cell" min="1" max="9" id="34" type="number"></td>
            <td><input class="sudoku-cell" min="1" max="9" id="35" type="number"></td>
          </tr>

          <tr>
            <td><input class="sudoku-cell" min="1" max="9" id="36" type="number"></td>
            <td><input class="sudoku-cell" min="1" max="9" id="37" type="number"></td>
            <td><input class="sudoku-cell" min="1" max="9" id="38" type="number"></td>

            <td><input class="sudoku-cell" min="1" max="9" id="39" type="number"></td>
            <td><input class="sudoku-cell" min="1" max="9" id="40" type="number"></td>
            <td><input class="sudoku-cell" min="1" max="9" id="41" type="number"></td>

            <td><input class="sudoku-cell" min="1" max="9" id="42" type="number"></td>
            <td><input class="sudoku-cell" min="1" max="9" id="43" type="number"></td>
            <td><input class="sudoku-cell" min="1" max="9" id="44" type="number"></td>
          </tr>

          <tr>
            <td><input class="sudoku-cell" min="1" max="9" id="45" type="number"></td>
            <td><input class="sudoku-cell" min="1" max="9" id="46" type="number"></td>
            <td><input class="sudoku-cell" min="1" max="9" id="47" type="number"></td>

            <td><input class="sudoku-cell" min="1" max="9" id="48" type="number"></td>
            <td><input class="sudoku-cell" min="1" max="9" id="49" type="number"></td>
            <td><input class="sudoku-cell" min="1" max="9" id="50" type="number"></td>

            <td><input class="sudoku-cell" min="1" max="9" id="51" type="number"></td>
            <td><input class="sudoku-cell" min="1" max="9" id="52" type="number"></td>
            <td><input class="sudoku-cell" min="1" max="9" id="53" type="number"></td>
          </tr>

          <tr>
            <td><input class="sudoku-cell" min="1" max="9" id="54" type="number"></td>
            <td><input class="sudoku-cell" min="1" max="9" id="55" type="number"></td>
            <td><input class="sudoku-cell" min="1" max="9" id="56" type="number"></td>

            <td><input class="sudoku-cell" min="1" max="9" id="57" type="number"></td>
            <td><input class="sudoku-cell" min="1" max="9" id="58" type="number"></td>
            <td><input class="sudoku-cell" min="1" max="9" id="59" type="number"></td>

            <td><input class="sudoku-cell" min="1" max="9" id="60" type="number"></td>
            <td><input class="sudoku-cell" min="1" max="9" id="61" type="number"></td>
            <td><input class="sudoku-cell" min="1" max="9" id="62" type="number"></td>
          </tr>

          <tr>
            <td><input class="sudoku-cell" min="1" max="9" id="63" type="number"></td>
            <td><input class="sudoku-cell" min="1" max="9" id="64" type="number"></td>
            <td><input class="sudoku-cell" min="1" max="9" id="65" type="number"></td>

            <td><input class="sudoku-cell" min="1" max="9" id="66" type="number"></td>
            <td><input class="sudoku-cell" min="1" max="9" id="67" type="number"></td>
            <td><input class="sudoku-cell" min="1" max="9" id="68" type="number"></td>

            <td><input class="sudoku-cell" min="1" max="9" id="69" type="number"></td>
            <td><input class="sudoku-cell" min="1" max="9" id="70" type="number"></td>
            <td><input class="sudoku-cell" min="1" max="9" id="71" type="number"></td>
          </tr>

          <tr>
            <td><input class="sudoku-cell" min="1" max="9" id="72" type="number"></td>
            <td><input class="sudoku-cell" min="1" max="9" id="73" type="number"></td>
            <td><input class="sudoku-cell" min="1" max="9" id="74" type="number"></td>

            <td><input class="sudoku-cell " min="1" max="9" id="75" type="number"></td>
            <td><input class="sudoku-cell" min="1" max="9" id="76" type="number"></td>
            <td><input class="sudoku-cell" min="1" max="9" id="77" type="number"></td>

            <td><input class="sudoku-cell" maxlength="1" min="1" max="9" id="78" type="number"></td>
            <td><input class="sudoku-cell" min="1" max="9" id="79" type="number"></td>
            <td><input class="sudoku-cell" maxlength="1" min="1" max="9" id="80" type="number"></td>
          </tr>

        </table>
        </div>
        <div class="col-lg-6">
          <div class="card">
            <div class="card-header">
            </div>
            <div class="card-body">
              <div class="row">
              <div class="col-lg-6">
                <ul class="list-group list-group-flush">
                <li class="list-group-item"><button class="btn btn-primary" id="generated-matrix">Gerar matriz</button> <button class="btn btn-success">Reiniciar</button> </li>
                <li class="list-group-item">Valores Disponíveis <input class="form-control" id="available-values" type="text"></li>
                </ul>
              </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

  </body>

  <script src="https://code.jquery.com/jquery-3.3.1.js" integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60=" crossorigin="anonymous"></script>
  <script>
    $(".sudoku-cell").bind("click", function () {
        $.ajax({
            type: 'GET',
            url: "http://localhost:29165/sudokuRest/sudoku/available/"+$(this).attr('id'),
            headers: {
                "Access-Control-Allow-Origin": "http://localhost:29165/sudokuRest/sudoku/"
            },
            contentType: "application/json; charset=utf-8"
        }).done(function(data){
            $("#available-values").val(data.available);
        });
    });
    $(".sudoku-cell").bind("change", function () {
        alert($(this).val());
    });
    $("#generated-matrix").bind("click", function () {
        $.ajax({
            type: 'GET',
            url: "http://localhost:29165/sudokuRest/sudoku/matrix",
            headers: {
                "Access-Control-Allow-Origin": "http://localhost:29165/sudokuRest/sudoku/matrix"
            },
            contentType: "application/json; charset=utf-8"
        }).done(function(data){
            for(var i = 0;i<data.result.length;i++){
                if(data.result[i].value !=0) {
                    $("#" + data.result[i].node).val(data.result[i].value);
                }
            }
        });
    });

  </script>

</html>