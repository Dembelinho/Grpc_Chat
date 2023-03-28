package ma.enset.service;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class server {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server= ServerBuilder.forPort(5151)
                .addService(new ChatGrpcService())
                .build();
        server.start();
        System.out.println("Server Starteeeed....");
        server.awaitTermination();

    }
}