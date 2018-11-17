<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="component/header.jsp"></jsp:include>
            <div id="login-area">

                <form class="form-login" action="login" method="post">
                    <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
                    <c:if test="${error_login != null}">
                        <div class="alert alert-danger" role="alert">
                            <c:out value="${error_login}"/>
                        </div>
                    </c:if>
                    <label for="inputUsername" class="sr-only">Username</label>
                    <input type="text" name="username" id="inputUsername" class="form-control" placeholder="Username" required autofocus value="${username}">
                    <label for="inputPassword" class="sr-only">Password</label>
                    <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required value="${password}">
                    <div class="checkbox mb-3">
                        <label>
                            <input type="checkbox" value="yes" name="remember" ${remember}> Remember me
                        </label>
                    </div>
                    <button class="btn btn-lg btn-primary btn-block" type="submit">Log in</button>
                </form>

            </div>
<jsp:include page="component/footer.jsp"></jsp:include>