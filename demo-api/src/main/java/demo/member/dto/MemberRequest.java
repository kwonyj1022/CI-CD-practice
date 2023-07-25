package demo.member.dto;

import demo.member.domain.Member;

public record MemberRequest(String email, String password) {

    public Member toEntity() {
        return new Member(email, password);
    }
}
