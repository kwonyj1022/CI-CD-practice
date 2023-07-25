package demo.member.controller;

import demo.member.domain.Member;
import demo.member.dto.MemberRequest;
import demo.member.dto.MemberResponse;
import demo.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody final MemberRequest request) {
        final Long memberId = memberService.create(request);

        return ResponseEntity.created(URI.create("/members/" + memberId)).build();
    }

    @GetMapping
    public ResponseEntity<List<MemberResponse>> readAllMember() {
        final List<Member> members = memberService.readAll();
        final List<MemberResponse> response = members.stream()
                .map(MemberResponse::from)
                .toList();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<MemberResponse> readByMemberId(@PathVariable final Long memberId) {
        final Member member = memberService.readByMemberId(memberId);
        final MemberResponse response = MemberResponse.from(member);

        return ResponseEntity.ok(response);
    }
}
