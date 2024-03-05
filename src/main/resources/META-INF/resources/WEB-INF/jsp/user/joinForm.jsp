<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@include file="../layout/header.jsp"%>
<div class="container">
    <form action="/user/join" method="post">
        <div class="form-group">
            <label for="username">Username:</label>
            <input type="text" class="form-control" placeholder="Enter Username" id="username">
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" class="form-control" placeholder="Enter password" id="password">
        </div>
        <div class="form-group">
            <label for="email">Email address:</label>
            <input type="email" class="form-control" placeholder="Enter email" id="email">
        </div>
    </form>
        <button id="btn-save" class="btn btn-primary">회원가입완료</button>
</div>
<%--<script src="/blog/js/user.js" ></script>--%>
<script>
    let index = {
        init: function () {
            document.querySelector("#btn-save").addEventListener('click',() =>{
                this.save();
            })
        },

        save: function () {
            let data = {
                username: document.querySelector("#username").value,
                password: document.querySelector("#password").value,
                email: document.querySelector("#email").value,
            }

            try {
                const response = fetch("/blog/api/user", {
                    method: "post",
                    headers: {
                        "Content-Type": "application/json"
                    },
                    body: JSON.stringify(data)
                })

            } catch(error) {
                alert(error);
                console.log(error);
            }
        }
    }
    index.init();
</script>
<%@include file="../layout/footer.jsp"%>
