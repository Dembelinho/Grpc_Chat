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
        System.out.print("Enter Ur Username : ");
        username=scanner.next();
        System.out.println(username+ " connected ...");
        System.out.println("To disconnect tape (exit) ...");

        StreamObserver<Chat.CurrencyRequest> performStream = asyncStub.fullCurrencyStream(new StreamObserver<Chat.CurrencyRequest>() {
                    @Override
                    public void onNext(Chat.CurrencyRequest currencyRequest) {
                        String messageFrom = currencyRequest.getCurrencyFrom();
                        String request = currencyRequest.getRequest();

                        System.out.println(messageFrom+" : "+request);
                    }

                    @Override
                    public void onError(Throwable throwable) {

                    }

                    @Override
                    public void onCompleted() {
                        System.out.println(" Compleeeeeeeeted....");
                    }
        });

        while (true) {
            System.out.println("*--*----------*--*----------*--*-----------*--*");
            System.out.print("Message To : ");
            String messageTo = scanner.nextLine();
            scanner.next();
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

                    }
                });
                //System.in.read();
                break;
            }
        }
        Timer timer=new Timer();
        timer.schedule(new TimerTask() {
            int cpt;
            @Override
            public void run() {
                System.out.println("Entrez votre tentative");
                Scanner scanner=new Scanner(System.in);
                String request = scanner.nextLine();
                Chat.CurrencyRequest currencyRequest= Chat.CurrencyRequest.newBuilder()
                        .setCurrencyTo("Server")
                        .setCurrencyFrom("Client")
                        .setRequest(request)
                        .build();
                performStream.onNext(currencyRequest);
                //System.out.println("==============> counter = "+ cpt);
                ++cpt;
                if (cpt==20){
                    performStream.onCompleted();
                    timer.cancel();
                }
            }
        }, 1000, 1000);

        System.out.println("0.....0.00.0000.......");
        System.in.read();
    }
}
