package com.niit.grpcapp.services;

import com.github.javafaker.Faker;
import com.niit.grpcapp.proto.MessageReply;
import com.niit.grpcapp.proto.MessageRequest;
import com.niit.grpcapp.proto.SimpleMessageGrpc;
import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Service;

@Service

public class GrpcServiceImpl extends SimpleMessageGrpc.SimpleMessageImplBase {
    @Override
    public void sendMessage(MessageRequest request, StreamObserver<MessageReply> responseObserver) {
        MessageReply reply = MessageReply.newBuilder().setMessage(new Faker().lorem().paragraph()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void streamMessage(MessageRequest request, StreamObserver<MessageReply> responseObserver) {
        Faker faker = new Faker();
        for (int i = 1; i <= 15; i++) {
            responseObserver.onNext(
                    MessageReply.newBuilder().setMessage(faker.lorem().paragraph()+"->"+faker.number().numberBetween(1,100)).build()
            );
            try { Thread.sleep(500); } catch (InterruptedException ignored) { }
        }
        responseObserver.onCompleted();
    }

}
