package ma.enset.service;

import io.grpc.stub.StreamObserver;
import ma.enset.stubs.Chat;
import ma.enset.stubs.ChatServiceGrpc;

import java.util.HashMap;

public class ChatGrpcService extends ChatServiceGrpc.ChatServiceImplBase {
    HashMap<String, StreamObserver<Chat.CurrencyRequest>> clientsHM=new HashMap<>();

    @Override
    public StreamObserver<Chat.CurrencyRequest> fullCurrencyStream(StreamObserver<Chat.CurrencyRequest> responseObserver) {

        return new StreamObserver<Chat.CurrencyRequest>() {
            @Override
            public void onNext(Chat.CurrencyRequest currencyRequest) {
                String messageFrom = currencyRequest.getCurrencyFrom();
                String messageTo = currencyRequest.getCurrencyTo();
                if(!clientsHM.containsKey(messageFrom)){
                    clientsHM.put(messageFrom,responseObserver);
                }
                if(messageTo.isEmpty()){
                    for(String s : clientsHM.keySet()){
                        if(!s.equals(messageFrom)) {
                            clientsHM.get(s).onNext(currencyRequest);
                        }
                    }
                }
                else if(clientsHM.containsKey(messageTo)){
                    StreamObserver<Chat.CurrencyRequest> currencyRequestStreamObserver = clientsHM.get(messageTo);
                    currencyRequestStreamObserver.onNext(currencyRequest);
                }
                /*
                Chat.CurrencyResponse response = Chat.CurrencyResponse.newBuilder()
                        .setResult("Length ==>"+currencyRequest.getRequest().length())
                        .setCurrencyTo("Client")
                        .setCurrencyFrom("Server")
                        .build();
                responseObserver.onNext(response);
                 */
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("error : "+throwable);
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }
    @Override
    public void disconnectRequest(Chat.connect request, StreamObserver<Chat.CurrencyRequest> responseObserver) {
        String username = request.getUsername();
        clientsHM.get(username).onCompleted();
        clientsHM.remove(username);
        Chat.CurrencyRequest request1 = Chat.CurrencyRequest.newBuilder()
                .setCurrencyFrom("Server")
                .setRequest("You are disconnected")
                .build();
        responseObserver.onNext(request1);
        responseObserver.onCompleted();
    }

}
