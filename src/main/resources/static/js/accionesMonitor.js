var stompClient = null;
var socket = new SockJS('/ws');
        stompClient = Stomp.over(socket);
        stompClient.connect({}, function(frame) {
            console.log(frame);
            stompClient.subscribe('/all/messages', function(result) {
                show(JSON.parse(result.body));
            });
        });

function show(message) {
                var response = document.getElementById('notificaciones');
                var p = document.createElement('p');
                p.innerHTML= "message: "  + message.text;
                response.appendChild(p);
            }