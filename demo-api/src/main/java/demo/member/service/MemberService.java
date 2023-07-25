package demo.member.service;

import demo.member.domain.Member;
import demo.member.domain.MemberRepository;
import demo.member.dto.MemberRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Long create(final MemberRequest request) {
        final Member createdMember = memberRepository.save(request.toEntity());
        return createdMember.getId();
    }

    public List<Member> readAll() {
        return memberRepository.findAll();
    }

    public Member readByMemberId(final Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow();
    }
}
