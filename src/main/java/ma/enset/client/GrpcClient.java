package ma.enset.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import ma.enset.service.ChatGrpcService;
import ma.enset.stubs.Chat;
import ma.enset.stubs.ChatServiceGrpc;

import java.io.IOException;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class GrpcClient {
    public static void main(String[] args) throws IOException {
        ManagedChannel managedChannel= ManagedChannelBuilder.forAddress("localhost",5151)
                .usePlaintext()
                .build();
        ChatServiceGrpc.ChatServiceStub asyncStub= ChatServiceGrpc.newStub(managedChannel);

        String username;
        String message;
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter ur name : ");
        username=scanner.next();
        System.out.println(username+ " connected ...");
        System.out.println("To disconnect tape (exit) ...");

        StreamObserver<Chat.CurrencyRequest> performStream = asyncStub.fullCurrencyStream(new StreamObserver<Chat.CurrencyRequest>() {
                    @Override
                    public void onNext(Chat.CurrencyRequest currencyRequest) {
                        String messageFrom = currencyRequest.getCurrencyFrom();
                        String request = currencyRequest.getRequest();
                        System.out.println();
                        System.out.println("Message >> "+request);
                        System.out.println("from : "+messageFrom);
                    }

                    @Override
                    public void onError(Throwable throwable) {

                    }

                    @Override
                    public void onCompleted() {

                    }
        });

        while (true) {
            System.out.println("*--*----------*--*----------*--*-----------*--*");
            System.out.print("Message To : ");
            String messageTo = scanner.next();
            scanner.nextLine();

            try {
                Thread.sleep(1000);
            }catch (InterruptedException exception){
                exception.getMessage();
            }

            System.out.print("Message : ");
            message = scanner.nextLine();
            System.out.println(message);

            if (message.equals("exit")) {
                Chat.connect disconnect = Chat.connect.newBuilder().setUsername(username).build();
                asyncStub.disconnectRequest(disconnect, new StreamObserver<Chat.CurrencyRequest>() {
                    @Override
                    public void onNext(Chat.CurrencyRequest currencyRequest) {
                        System.out.println(currencyRequest.getRequest());
                    }

                    @Override
                    public void onError(Throwable throwable) {

                    }

                    @Override
                    public void onCompleted() {
                        System.out.println(" Compleeeeeeeeted....");
                    }
                });
               // break;
            }
            Chat.CurrencyRequest request = Chat.CurrencyRequest.newBuilder()
                    .setCurrencyFrom(username)
                    .setCurrencyTo(messageTo)
                    .setRequest(message)
                    .build();
            performStream.onNext(request);
        }
        //System.in.read();
    }
}
