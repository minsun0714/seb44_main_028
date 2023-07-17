package com.ftiland.travelrental.chat.mapper;

import com.ftiland.travelrental.chat.dto.ResponseDto;
import com.ftiland.travelrental.chat.entity.ChatMessage;
import com.ftiland.travelrental.chat.entity.ChatRoom;
import com.ftiland.travelrental.chat.repository.ChatRoomMembersRepository;
import com.ftiland.travelrental.member.entity.Member;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ChatMapper {

    default ResponseDto.Post chatRoomToResponseDto(ChatRoomMembersRepository chatRoomMembersRepository, ChatRoom chatRoom) {
        ResponseDto.Post response = new ResponseDto.Post();
        response.setRoomId(chatRoom.getChatroomId());
        response.setName(chatRoom.getName());
        List<Member> memberList = chatRoomMembersRepository.findByChatroomId(chatRoom.getChatroomId());
        for (Member member : memberList) {
            response.addMemberId(member);
        }
        return response;
    }

    default ResponseDto.Message chatMesssageToResponseMessage(ChatMessage chatMessage) {
        ResponseDto.Message response = new ResponseDto.Message();
        response.setContent(chatMessage.getContent());
        response.setMemberId(chatMessage.getSenderId());
        response.setCreatedAt(chatMessage.getCreatedAt());

        return response;
    }

    default ResponseDto.Messages ChatMessagesToResponseMessages(List<ChatMessage> messageList) {
        ResponseDto.Messages response = new ResponseDto.Messages();
        for (ChatMessage c : messageList) {
            ResponseDto.Message message = chatMesssageToResponseMessage(c);
            response.addMessage(message);
        }

        return response;
    }

    default ResponseDto.ChatRoom ChatRoomToResponseChatRoom(ChatRoom chatRoom){
        ResponseDto.ChatRoom response = new ResponseDto.ChatRoom();
        response.setChatroomId(chatRoom.getChatroomId());

        return response;
    }

    default ResponseDto.ChatRooms ChatRoomsToChatRoomList(List<ChatRoom> chatRooms){
        ResponseDto.ChatRooms responses = new ResponseDto.ChatRooms();
        for (ChatRoom chatRoom : chatRooms){
            ResponseDto.ChatRoom chatRoomElement = ChatRoomToResponseChatRoom(chatRoom);
            responses.addChatRoom(chatRoomElement);
        }

        return responses;
    }
}
