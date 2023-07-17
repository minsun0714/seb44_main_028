package com.ftiland.travelrental.common.exception;

import lombok.Getter;

public enum ExceptionCode {
    NOT_EXISTS(409,"Not exists"),
    INTEREST_EXISTS(409,"Interest exists"),
    IMAGE_EMPTY(501,"이미지가 없습니다."),
    MEMBER_NOT_FOUND(404, "멤버가 존재하지 않습니다."),
    MEMBER_EXISTS(409, "Member exists"),
    NOT_IMPLEMENTATION(501, "Not Implementation"),
    INVALID_MEMBER_STATUS(400, "Invalid member status"),
    PRODUCT_NOT_FOUND(404, "대여 물품이 존재하지 않습니다."),
    UNAUTHORIZED(403, "권한이 없습니다."),
    NOT_FOUND_LOCATION(403, "주소가 없습니다."),
    NOT_FOUND_RESERVATION(404, "예약이 존재하지 않습니다."),
    CATEGORY_NOT_FOUND(404, "존재하지 않는 카테고리입니다."),
    NOT_POSSIBLE_CANCEL(400, "예약취소 불가"),
    NOT_FOUND_IMAGE_MEMBER(404, "멤버 이미지가 존재하지 않습니다."),
    RESERVATION_NOT_ALLOWED(400, "상품에 예약할 수 없습니다.");

    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(int code, String message) {
        this.status = code;
        this.message = message;
    }
}