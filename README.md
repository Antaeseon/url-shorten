# url-shorten
## 프로젝트 개요
* Url을 input으로 받게 되면 단축된 url을 반환
   * 예를들어 https://n.news.naver.com/article/020/0003444165?ntype=RANKING 입력으로 받는다면 결과값으로 https://url-shorten.taeseon.com/aeh123 으로 반환

## 설계
* 트래픽 규모 산정
   * 매일 1억개 이상 단축 URL 생성 가능
* Url은 6자리로 단축할 수 있도록 설계
* High availability, Scalability를 고려 

## 기본 기능
* Url을 입력 받으면 축약해서 반환
* 축약된 Url을 받으면 원본 Url로 redirect