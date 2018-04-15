<%-- 
    Document   : main
    Created on : Apr 14, 2018, 7:01:22 PM
    Author     : juan
    --%>

    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1" charset="utf-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="css/util.css">
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <style>
        body {
            margin: 0 auto;
            width: 100%;
            padding: 0 20px;
            padding-top: 5%;
        }

        .container {
            border: 2px solid #dedede;
            background-color: #f1f1f1;
            border-radius: 5px;
            padding: 10px;
            margin: 10px 0;
        }

        .darker {
            border-color: #ccc;
            background-color: #ddd;
        }

        .container::after {
            content: "";
            clear: both;
            display: table;
        }

        .time-right {
            float: right;
            color: #aaa;
        }

        .time-left {
            float: left;
            color: #999;
        }

        #messages {
            display: inline-block;
            height: 500px;
            max-height: 500px;
            width: 70%;
            border: 0.5px solid #d3d3d3;
            padding: 0px 10px 0px 10px;
            overflow: scroll;
        }

        #nicknames {
            position: fixed;
            display: inline-block;
            width: 10%;
            margin-left: 1%;
            overflow: scroll;
            max-height: 500px;
        }

        #display {
            margin: 0 auto;
            width: 50%;

        }

        #send {
            width: 50%;
            margin: 0 auto;
        }

        #text {

            display: inline-block;
            width: 70%
        }
    </style>
</head>
<body>
    <div id="display">
        <div id="messages">
            <h3 style="text-align: center;">Chat Messages</h3>
            <div class="data_ms">
                <div class="container" v-for="message in messages.array">
                    <span class="time-left" style="color: red">{{message.nickname}}</span><br>
                    <p>{{message.content}}</p>
                </div>
            </div>  
        </div>
        <div id="nicknames" class="data_us">
            <ol class="list-group">
                <li class="list-group-item" v-for="user in users.array">{{user.nickname}}</li>
            </ol>
        </div>  
    </div>
    <div id="send">
        <div class="form-group" id="text">
            <label for="comment">Message:</label>
            <textarea class="form-control" rows="3" id="comment" name="message" form="postform"></textarea>
        </div>
        <form method="POST" action="messages" id="postform" >
            <input type="hidden" name="nickname" value="${sessionScope.nickname}">
            <button class="login100-form-btn" id="sender" type="submit">
                Send
            </button>
        </form> 
    </div>
    <script src="js/vue.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/vue-resource@1.5.0"></script>
    <script type="text/javascript">
        var vm_user = new Vue({
            el: '.data_us',
            data: {
                users: {'array': []}
            },
            methods: {
                loadUsers: function () {
                    Vue.http.get('http://localhost:8080/user?list=true').then(res => {
                        Vue.set(vm_user.users, 'array', res.body);
                    }, (error) => {
                        console.log(error);
                    });
                }
            },
            mounted: function () {
                this.loadUsers();
                setInterval(function () {
                    console.log("updating user list");
                    this.loadUsers();
                }.bind(this), 2000);
            }
        });
        //
        var vm_ms = new Vue({
            el: '.data_ms',
            data : {
                messages: {'array': []}
            },
            methods: {
                loadMessages: function () {
                    Vue.http.get('http://localhost:8080/messages?list=true').then(res => {
                        Vue.set(vm_ms.messages, 'array', res.body);
                    }, (error) => {
                        console.log(error);
                    });
                }
            },
            mounted: function () {
                this.loadMessages();
                setInterval(function () {
                    console.log("updating messages list");
                    this.loadMessages();
                }.bind(this), 2000);
            }
        });
    </script>
</body>
</html>
