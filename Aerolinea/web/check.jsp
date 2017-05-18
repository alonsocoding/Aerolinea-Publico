<%-- 
    Document   : check
    Created on : May 18, 2017, 12:25:49 AM
    Author     : AndreyCh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Baratísimo</title>
        <%@ include file="Imports.jspf" %> 
    </head>
    <body>
      <!-- Titulo de la pagina -->
      <header>
        <div class="container"><h1>&nbsp;&nbsp;Baratísimo <span class="glyphicon glyphicon-plane avion"></span></h1></div>
      </header>
      <!-- Menu de Navegacion -->
      <nav class="navbar navbar-inverse">
        <div class="container">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
          </div>
          <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
              <li class="active"><a href="index.jsp">Principal</a></li>
              <li><a href="informacion.jsp">Información</a></li>
              <li><a href="historia.jsp">Historia</a></li>
              <li><a href="contacto.jsp">Contacto</a></li>
            </ul>
            <form class="navbar-form navbar-right">
              <div class="form-group">
                <input placeholder="Email" class="form-control" type="text">
              </div>
              <div class="form-group">
                <input placeholder="Password" class="form-control" type="password">
              </div>
              <button type="submit" class="btn btn-success">Iniciar Sesion</button>
              <a href="registro.jsp" type="button" class="btn btn-primary">Crear cuenta</a>
            </form>
          </div>
        </div>
      </nav>
      <!-- Form -->
        <div class="container">
          <h1>Reservar asientos</h1>
          <hr>
          <form method="post">
          <table id="check" class="table">
              <thead class="thead-default">
                <tr>
                  <th>#</th>
                  <th>A</th>
                  <th>B</th>
                  <th>C</th>
                  <th> </th>
                  <th>E</th>
                  <th>F</th>
                  <th>G</th>
                </tr>
              </thead>
            <tbody>
              <tr>
                <th scope="row">1</th>
                <td>
                    <label class="btn btn-default">
                      <img src="images/Libre.png" alt="libre" class="img-thumbnail img-check">
                      <input type="checkbox" name="chk1" id="seat" value="val1" class="hidden" autocomplete="off">
                    </label>
                </td>
                <td>
                    <label class="btn btn-default">
                      <img src="images/Libre.png" alt="libre" class="img-thumbnail img-check">
                      <input type="checkbox" name="chk1" id="seat" value="val1" class="hidden" autocomplete="off">
                    </label>
                </td>
                <td>
                    <label class="btn btn-default">
                      <img src="images/Libre.png" alt="libre" class="img-thumbnail img-check">
                      <input type="checkbox" name="chk1" id="seat" value="val1" class="hidden" autocomplete="off">
                    </label>
                </td>
                <td> </td>
                <td>
                    <label class="btn btn-default">
                      <img src="images/Libre.png" alt="libre" class="img-thumbnail img-check">
                      <input type="checkbox" name="chk1" id="seat" value="val1" class="hidden" autocomplete="off">
                    </label>
                </td>
                <td>
                    <label class="btn btn-default">
                      <img src="images/Libre.png" alt="libre" class="img-thumbnail img-check">
                      <input type="checkbox" name="chk1" id="seat" value="val1" class="hidden" autocomplete="off">
                    </label>
                </td>
                <td>
                    <label class="btn btn-default">
                      <img src="images/Libre.png" alt="libre" class="img-thumbnail img-check">
                      <input type="checkbox" name="chk1" id="seat" value="val1" class="hidden" autocomplete="off">
                    </label>
                </td>
              </tr>
              <tr>
                <th scope="row">2</th>
                <td>
                    <label class="btn btn-default">
                      <img src="images/Libre.png" alt="libre" class="img-thumbnail img-check">
                      <input type="checkbox" name="chk1" id="item4" value="val1" class="hidden" autocomplete="off">
                    </label>
                </td>
                <td>
                    <label class="btn btn-default">
                      <img src="images/Libre.png" alt="libre" class="img-thumbnail img-check">
                      <input type="checkbox" name="chk1" id="item4" value="val1" class="hidden" autocomplete="off">
                    </label>
                </td>
                <td>
                    <label class="btn btn-default">
                      <img src="images/Libre.png" alt="libre" class="img-thumbnail img-check">
                      <input type="checkbox" name="chk1" id="item4" value="val1" class="hidden" autocomplete="off">
                    </label>
                </td>
                <td> </td>
                <td>
                    <label class="btn btn-default">
                      <img src="images/Libre.png" alt="libre" class="img-thumbnail img-check">
                      <input type="checkbox" name="chk1" id="item4" value="val1" class="hidden" autocomplete="off">
                    </label>
                </td>
                <td>
                    <label class="btn btn-default">
                      <img src="images/Libre.png" alt="libre" class="img-thumbnail img-check">
                      <input type="checkbox" name="chk1" id="item4" value="val1" class="hidden" autocomplete="off">
                    </label>
                </td>
                <td>
                    <label class="btn btn-default">
                      <img src="images/Libre.png" alt="libre" class="img-thumbnail img-check">
                      <input type="checkbox" name="chk1" id="item4" value="val1" class="hidden" autocomplete="off">
                    </label>
                </td>
              </tr>
              <tr>
                <th scope="row">3</th>
                <td>
                    <label class="btn btn-default">
                      <img src="images/Libre.png" alt="libre" class="img-thumbnail img-check">
                      <input type="checkbox" name="chk1" id="item4" value="val1" class="hidden" autocomplete="off">
                    </label>
                </td>
                <td>
                    <label class="btn btn-default">
                      <img src="images/Libre.png" alt="libre" class="img-thumbnail img-check">
                      <input type="checkbox" name="chk1" id="item4" value="val1" class="hidden" autocomplete="off">
                    </label>
                </td>
                <td>
                    <label class="btn btn-default">
                      <img src="images/Libre.png" alt="libre" class="img-thumbnail img-check">
                      <input type="checkbox" name="chk1" id="item4" value="val1" class="hidden" autocomplete="off">
                    </label>
                </td>
                <td> </td>
                <td>
                    <label class="btn btn-default">
                      <img src="images/Libre.png" alt="libre" class="img-thumbnail img-check">
                      <input type="checkbox" name="chk1" id="item4" value="val1" class="hidden" autocomplete="off">
                    </label>
                </td>
                <td>
                    <label class="btn btn-default">
                      <img src="images/Libre.png" alt="libre" class="img-thumbnail img-check">
                      <input type="checkbox" name="chk1" id="item4" value="val1" class="hidden" autocomplete="off">
                    </label>
                </td>
                <td>
                    <label class="btn btn-default">
                      <img src="images/Libre.png" alt="libre" class="img-thumbnail img-check">
                      <input type="checkbox" name="chk1" id="item4" value="val1" class="hidden" autocomplete="off">
                    </label>
                </td>
              </tr>
              <tr>
                <th scope="row">4</th>
                <td>
                    <label class="btn btn-default">
                      <img src="images/Libre.png" alt="libre" class="img-thumbnail img-check">
                      <input type="checkbox" name="chk1" id="item4" value="val1" class="hidden" autocomplete="off">
                    </label>
                </td>
                <td>
                    <label class="btn btn-default">
                      <img src="images/Libre.png" alt="libre" class="img-thumbnail img-check">
                      <input type="checkbox" name="chk1" id="item4" value="val1" class="hidden" autocomplete="off">
                    </label>
                </td>
                <td>
                    <label class="btn btn-default">
                      <img src="images/Libre.png" alt="libre" class="img-thumbnail img-check">
                      <input type="checkbox" name="chk1" id="item4" value="val1" class="hidden" autocomplete="off">
                    </label>
                </td>
                <td> </td>
                <td>
                    <label class="btn btn-default">
                      <img src="images/Libre.png" alt="libre" class="img-thumbnail img-check">
                      <input type="checkbox" name="chk1" id="item4" value="val1" class="hidden" autocomplete="off">
                    </label>
                </td>
                <td>
                    <label class="btn btn-default">
                      <img src="images/Libre.png" alt="libre" class="img-thumbnail img-check">
                      <input type="checkbox" name="chk1" id="item4" value="val1" class="hidden" autocomplete="off">
                    </label>
                </td>
                <td>
                    <label class="btn btn-default">
                      <img src="images/Libre.png" alt="libre" class="img-thumbnail img-check">
                      <input type="checkbox" name="chk1" id="item4" value="val1" class="hidden" autocomplete="off">
                    </label>
                </td>
              </tr>
              <tr>
                <th scope="row">5</th>
                <td>
                    <label class="btn btn-default">
                      <img src="images/Libre.png" alt="libre" class="img-thumbnail img-check">
                      <input type="checkbox" name="chk1" id="item4" value="val1" class="hidden" autocomplete="off">
                    </label>
                </td>
                <td>
                    <label class="btn btn-default">
                      <img src="images/Libre.png" alt="libre" class="img-thumbnail img-check">
                      <input type="checkbox" name="chk1" id="item4" value="val1" class="hidden" autocomplete="off">
                    </label>
                </td>
                <td>
                    <label class="btn btn-default">
                      <img src="images/Libre.png" alt="libre" class="img-thumbnail img-check">
                      <input type="checkbox" name="chk1" id="item4" value="val1" class="hidden" autocomplete="off">
                    </label>
                </td>
                <td> </td>
                <td>
                    <label class="btn btn-default">
                      <img src="images/Libre.png" alt="libre" class="img-thumbnail img-check">
                      <input type="checkbox" name="chk1" id="item4" value="val1" class="hidden" autocomplete="off">
                    </label>
                </td>
                <td>
                    <label class="btn btn-default">
                      <img src="images/Libre.png" alt="libre" class="img-thumbnail img-check">
                      <input type="checkbox" name="chk1" id="item4" value="val1" class="hidden" autocomplete="off">
                    </label>
                </td>
                <td>
                    <label class="btn btn-default">
                      <img src="images/Libre.png" alt="libre" class="img-thumbnail img-check">
                      <input type="checkbox" name="chk1" id="item4" value="val1" class="hidden" autocomplete="off">
                    </label>
                </td>
              </tr>
              <tr>
                <th scope="row">6</th>
                <td>
                    <label class="btn btn-default">
                      <img src="images/Libre.png" alt="libre" class="img-thumbnail img-check">
                      <input type="checkbox" name="chk1" id="item4" value="val1" class="hidden" autocomplete="off">
                    </label>
                </td>
                <td>
                    <label class="btn btn-default">
                      <img src="images/Libre.png" alt="libre" class="img-thumbnail img-check">
                      <input type="checkbox" name="chk1" id="item4" value="val1" class="hidden" autocomplete="off">
                    </label>
                </td>
                <td>
                    <label class="btn btn-default">
                      <img src="images/Libre.png" alt="libre" class="img-thumbnail img-check">
                      <input type="checkbox" name="chk1" id="item4" value="val1" class="hidden" autocomplete="off">
                    </label>
                </td>
                <td> </td>
                <td>
                    <label class="btn btn-default">
                      <img src="images/Libre.png" alt="libre" class="img-thumbnail img-check">
                      <input type="checkbox" name="chk1" id="item4" value="val1" class="hidden" autocomplete="off">
                    </label>
                </td>
                <td>
                    <label class="btn btn-default">
                      <img src="images/Libre.png" alt="libre" class="img-thumbnail img-check">
                      <input type="checkbox" name="chk1" id="item4" value="val1" class="hidden" autocomplete="off">
                    </label>
                </td>
                <td>
                    <label class="btn btn-default">
                      <img src="images/Libre.png" alt="libre" class="img-thumbnail img-check">
                      <input type="checkbox" name="chk1" id="item4" value="val1" class="hidden" autocomplete="off">
                    </label>
                </td>
              </tr>
              <tr>
                <th scope="row">7</th>
                <td>
                    <label class="btn btn-default">
                      <img src="images/Libre.png" alt="libre" class="img-thumbnail img-check">
                      <input type="checkbox" name="chk1" id="item4" value="val1" class="hidden" autocomplete="off">
                    </label>
                </td>
                <td>
                    <label class="btn btn-default">
                      <img src="images/Libre.png" alt="libre" class="img-thumbnail img-check">
                      <input type="checkbox" name="chk1" id="item4" value="val1" class="hidden" autocomplete="off">
                    </label>
                </td>
                <td>
                    <label class="btn btn-default">
                      <img src="images/Libre.png" alt="libre" class="img-thumbnail img-check">
                      <input type="checkbox" name="chk1" id="item4" value="val1" class="hidden" autocomplete="off">
                    </label>
                </td>
                <td> </td>
                <td>
                    <label class="btn btn-default">
                      <img src="images/Libre.png" alt="libre" class="img-thumbnail img-check">
                      <input type="checkbox" name="chk1" id="item4" value="val1" class="hidden" autocomplete="off">
                    </label>
                </td>
                <td>
                    <label class="btn btn-default">
                      <img src="images/Libre.png" alt="libre" class="img-thumbnail img-check">
                      <input type="checkbox" name="chk1" id="item4" value="val1" class="hidden" autocomplete="off">
                    </label>
                </td>
                <td>
                    <label class="btn btn-default">
                      <img src="images/Libre.png" alt="libre" class="img-thumbnail img-check">
                      <input type="checkbox" name="chk1" id="item4" value="val1" class="hidden" autocomplete="off">
                    </label>
                </td>
              </tr>
              <tr>
                <th scope="row">8</th>
                <td>
                    <label class="btn btn-default">
                      <img src="images/Libre.png" alt="libre" class="img-thumbnail img-check">
                      <input type="checkbox" name="chk1" id="item4" value="val1" class="hidden" autocomplete="off">
                    </label>
                </td>
                <td>
                    <label class="btn btn-default">
                      <img src="images/Libre.png" alt="libre" class="img-thumbnail img-check">
                      <input type="checkbox" name="chk1" id="item4" value="val1" class="hidden" autocomplete="off">
                    </label>
                </td>
                <td>
                    <label class="btn btn-default">
                      <img src="images/Libre.png" alt="libre" class="img-thumbnail img-check">
                      <input type="checkbox" name="chk1" id="item4" value="val1" class="hidden" autocomplete="off">
                    </label>
                </td>
                <td> </td>
                <td>
                    <label class="btn btn-default">
                      <img src="images/Libre.png" alt="libre" class="img-thumbnail img-check">
                      <input type="checkbox" name="chk1" id="item4" value="val1" class="hidden" autocomplete="off">
                    </label>
                </td>
                <td>
                    <label class="btn btn-default">
                      <img src="images/Libre.png" alt="libre" class="img-thumbnail img-check">
                      <input type="checkbox" name="chk1" id="item4" value="val1" class="hidden" autocomplete="off">
                    </label>
                </td>
                <td>
                    <label class="btn btn-default">
                      <img src="images/Libre.png" alt="libre" class="img-thumbnail img-check">
                      <input type="checkbox" name="chk1" id="item4" value="val1" class="hidden" autocomplete="off">
                    </label>
                </td>
              </tr>
              <tr>
                <th scope="row">9</th>
                <td>
                    <label class="btn btn-default">
                      <img src="images/Libre.png" alt="libre" class="img-thumbnail img-check">
                      <input type="checkbox" name="chk1" id="item4" value="val1" class="hidden" autocomplete="off">
                    </label>
                </td>
                <td>
                    <label class="btn btn-default">
                      <img src="images/Libre.png" alt="libre" class="img-thumbnail img-check">
                      <input type="checkbox" name="chk1" id="item4" value="val1" class="hidden" autocomplete="off">
                    </label>
                </td>
                <td>
                    <label class="btn btn-default">
                      <img src="images/Libre.png" alt="libre" class="img-thumbnail img-check">
                      <input type="checkbox" name="chk1" id="item4" value="val1" class="hidden" autocomplete="off">
                    </label>
                </td>
                <td> </td>
                <td>
                    <label class="btn btn-default">
                      <img src="images/Libre.png" alt="libre" class="img-thumbnail img-check">
                      <input type="checkbox" name="chk1" id="item4" value="val1" class="hidden" autocomplete="off">
                    </label>
                </td>
                <td>
                    <label class="btn btn-default">
                      <img src="images/Libre.png" alt="libre" class="img-thumbnail img-check">
                      <input type="checkbox" name="chk1" id="item4" value="val1" class="hidden" autocomplete="off">
                    </label>
                </td>
                <td>
                    <label class="btn btn-default">
                      <img src="images/Libre.png" alt="libre" class="img-thumbnail img-check">
                      <input type="checkbox" name="chk1" id="item4" value="val1" class="hidden" autocomplete="off">
                    </label>
                </td>
              </tr>
              <tr>
                <th scope="row">10</th>
                <td>
                    <label class="btn btn-default">
                      <img src="images/Libre.png" alt="libre" class="img-thumbnail img-check">
                      <input type="checkbox" name="chk1" id="item4" value="val1" class="hidden" autocomplete="off">
                    </label>
                </td>
                <td>
                    <label class="btn btn-default">
                      <img src="images/Libre.png" alt="libre" class="img-thumbnail img-check">
                      <input type="checkbox" name="chk1" id="item4" value="val1" class="hidden" autocomplete="off">
                    </label>
                </td>
                <td>
                    <label class="btn btn-default">
                      <img src="images/Libre.png" alt="libre" class="img-thumbnail img-check">
                      <input type="checkbox" name="chk1" id="item4" value="val1" class="hidden" autocomplete="off">
                    </label>
                </td>
                <td> </td>
                <td>
                    <label class="btn btn-default">
                      <img src="images/Libre.png" alt="libre" class="img-thumbnail img-check">
                      <input type="checkbox" name="chk1" id="item4" value="val1" class="hidden" autocomplete="off">
                    </label>
                </td>
                <td>
                    <label class="btn btn-default">
                      <img src="images/Libre.png" alt="libre" class="img-thumbnail img-check">
                      <input type="checkbox" name="chk1" id="item4" value="val1" class="hidden" autocomplete="off">
                    </label>
                </td>
                <td>
                    <label class="btn btn-default">
                      <img src="images/Libre.png" alt="libre" class="img-thumbnail img-check">
                      <input type="checkbox" name="chk1" id="item4" value="val1" class="hidden" autocomplete="off">
                    </label>
                </td>
              </tr>
              <tr>
                <th scope="row">11</th>
                <td>
                    <label class="btn btn-default">
                      <img src="images/Reservado.png" alt="libre" class="img-thumbnail img-check">
                      <input type="checkbox" name="chk1" id="item4" value="val1" class="hidden" autocomplete="off">
                    </label>
                </td>
                <td>
                    <label class="btn btn-default">
                      <img src="images/Reservado.png" alt="libre" class="img-thumbnail img-check">
                      <input type="checkbox" name="chk1" id="item4" value="val1" class="hidden" autocomplete="off">
                    </label>
                </td>
                <td>
                    <label class="btn btn-default">
                      <img src="images/Reservado.png" alt="libre" class="img-thumbnail img-check">
                      <input type="checkbox" name="chk1" id="item4" value="val1" class="hidden" autocomplete="off">
                    </label>
                </td>
                <td> </td>
                <td>
                    <label class="btn btn-default">
                      <img src="images/Reservado.png" alt="libre" class="img-thumbnail img-check">
                      <input type="checkbox" name="chk1" id="item4" value="val1" class="hidden" autocomplete="off">
                    </label>
                </td>
                <td>
                    <label class="btn btn-default">
                      <img src="images/Reservado.png" alt="libre" class="img-thumbnail img-check">
                      <input type="checkbox" name="chk1" id="item4" value="val1" class="hidden" autocomplete="off">
                    </label>
                </td>
                <td>
                    <label class="btn btn-default">
                      <img src="images/Reservado.png" alt="libre" class="img-thumbnail img-check">
                      <input type="checkbox" name="chk1" id="item4" value="val1" class="hidden" autocomplete="off">
                    </label>
                </td>
              </tr>
            </tbody>
          </table>
          <input type="button" class="btn btn-sucess" value="Continuar>>">
        </form>
        </div>
      <hr>
      <br><br><br>
      <!-- Footer -->
      <div class="container">
        <footer class="footer">
          <p>&copy; 2017 Baratísimo, Inc.</p>
        </footer>
      </div>
    </body>
</html>