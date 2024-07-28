package gift.user.presentation;


import gift.user.application.KakaoOauthService;
import gift.util.CommonResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KakaoOauthController {

    private final KakaoOauthService kakaoOauthService;

    public KakaoOauthController(KakaoOauthService kakaoOauthService) {
        this.kakaoOauthService = kakaoOauthService;
    }

    @GetMapping("/login")
    public ResponseEntity<?> loginForm() {
        return ResponseEntity
                .ok()
                .body(new CommonResponse<>(
                        kakaoOauthService.getKakaoLoginUrl(), "카카오 로그인 URL 생성 성공", true
                ));
    }

    @GetMapping("/logout")
    public ResponseEntity<?> logout(@RequestParam String accessToken) {
        kakaoOauthService.getKakaoLogout(accessToken);
        return ResponseEntity
                .ok()
                .body(new CommonResponse<>(null, "로그아웃 성공", true));
    }


    // TODO: 프론트가 /login/oauth2/code/kakao 로 요청을 보내면 카카오 로그인을 진행하고, 프론트에게 토큰을 반환한다. -> 근데 프론트가 AccessToken을 받아서 백엔드한테 보내는게 맞는거같은데?
    @GetMapping("/login/oauth2/code/kakao")
    public ResponseEntity<?> kakaoOauthCallback(@RequestParam String code) {
        return ResponseEntity
                .ok()
                .body(new CommonResponse<>(
                        kakaoOauthService.processKakaoLoginAndGenerateAccessToken(code), "카카오 로그인 성공", true
                ));
    }

    @PostMapping("/login/ok")
    public ResponseEntity<?> loginOk(@RequestParam String code) {
        return ResponseEntity
                .ok()
                .body(new CommonResponse<>(
                        kakaoOauthService.processKakaoLoginAndGenerateAccessToken(code), "카카오 로그인 성공", true
                ));
    }
}
