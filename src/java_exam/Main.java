package java_exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//자바에 존재하는 클래스, 메소드의 기능을 이렇게 다른 클래스에서 사용하려 하는 경우
//import라는 명령어를 이용해 연결해줍니다

public class Main {

	static List<Article> articles = new ArrayList<>();
	// 메인 클래스와 메서드 사이에 리스트를 만드는 것은
	// 메인 메서드 외에 다른 클래스에도 접근하기 위함입니다
	// static을 붙여 클래스 변수라는걸 나타냅니다
	//해당 클래스의 모든 인스턴스들이 공유하는 변수입니다 다른 메서드에서도 해당 리스트에 접근을 가능하게 합니다.
	//List와 ArrayList는 자바에서 제공하는 기능있는 클래스 이므로 import 합니다
	//List는 자바 자체에서 제공하는 인터페이스 중 하나로, 여러 개의 요소들을 순서에 따라 저장하고 관리할 수 있습니다.
    //List 인터페이스를 구현한 ArrayList 클래스를 이용하여, Article 객체들을 담을 수 있는 리스트를 생성하였습니다. 생성된 리스트의 이름은 articles이며
	//리스트 내부에는 Article 객체들이 담길 수 있습니다.
	//해당 ArrayList는 Article 타입의 변수 articles의 정보를 담기위해 시행하며
	//DB 대용으로 해당 프로젝트에서 저장값을 위해 쓰이는 중입니다
	public static void main(String[] args) {

		System.out.println("==프로그램 시작==");// 메인 메서드에서 가장 먼저 실행 될 출력문.
		makeTestData(); // makeTestData라는 함수를 실행 시킵니다 메인 메서드 안쪽에 만들었기에 Main.makeTestDate(); Main을 생략해도 됍니다

		Scanner sc = new Scanner(System.in);//출력문을 콘솔에 나타내기 위해
		 //스캐너 객체를 만들고 sc라는 변수에 담습니다 입력받을 대상은 표준입력 (System.in) 입니다
		 //스캐너 클래스는 자바에서 제공하기에 import 합니다

		int lastArticleId = 3;//글의 갯수를 저장하기 위한 정수 변수 초기화입니다
		//반복문 밖에 만든 이유는 반복문에서 계속 초기화 돼 값이 입력되지 않기 때문엡니다
		//3으로 하는 이유는 테스트 데이터를 3개 만들어서 3개를 기본값으로 가정하고 시작합니다.

		while (true) { // 명령어를 실행 하기 위한 무한 반복문의 시작

			System.out.print("명령어 > ");
			String command = sc.nextLine().trim(); //문자열 변수 command는
			//스캐너 변수 sc의 기능 nextLine()과 trim을 저장합니다

			if (command.length() == 0) {// 입력한 글자가 0이면 (없으면)
				System.out.println("명령어를 입력해주세요");//이것을 출력
				continue;//반복문으로 돌아갑니다 
			}

			if (command.equals("exit")) {//입력한 글자가 exit와 같다면
				break;//반복문을 빠져나갑니다
			}

			if (command.equals("article list")) {//입력한 글자가 article list라면
				if (articles.size() == 0) {//배열에 담겨둔 articles에서 저장해둔게 0이라면
					System.out.println("게시글이 없습니다");//출력
				} else {//그게 아니면 게시글 있다는것이니
					System.out.println(" 번호  //  제목    //  조회  ");//출력
					for (int i = articles.size() - 1; i >= 0; i--) {//i를 articles 길이의 배열 변수로 -1을 한 뒤 초기화합니다.조건식은 i가0이상일때이며 ,증감식은 i를 1씩 줄여갑니다
						Article article = articles.get(i);//Article 타입의 변수 article에는 artcles의 기능을 받습니다
						System.out.printf("  %d   //   %s   //   %d  \n", article.id, article.title, article.hit);
					}//그 결과 article.id,article.title,article.hit에 저장된 값을 %d(정수형) %s(문자형)으로 출력하고 \n 줄바꿈 합니다
				}

			} else if (command.equals("article write")) {//article list가 아닌 article write를 입력한다면
				int id = lastArticleId + 1; //id를 lastAtricleId(글번호) 0번부터가 아닌 1번부터 하기에 1을 더 한 값을 초기화시키고
				System.out.print("제목 : "); //제목 : 출력
				String regDate = Util.getNowDateTimeStr();//제목에 regDate(시점)이 담깁니다
				String title = sc.nextLine();//title이란 문자열 변수엔 선언해둔 스크린 변수sc의 nextLine();기능을 담습니다
				System.out.print("내용 : ");
				String body = sc.nextLine();//body이란 문자열 변수엔 선언해둔 스크린 변수sc의 nextLine();기능을 담습니다

				Article article = new Article(id, regDate, regDate, title, body);
				//Article 타입 article이란 변수에 객체 Article클래스를 담습니다 클래스 생성자 첫번째의 기능을 담습니다
				articles.add(article);
				//ArrayList클래스의 객체인 articles에 article이란 객체를 추가하는 작업입니다
				//article write에 쓰인 값들을 ArrayList에 저장하기 위함입니다

				System.out.printf("%d번글이 생성되었습니다\n", id);
			    //id 값에 담긴 %d(정수형)으로 출력하고 줄 바꿈
				lastArticleId++;//lastArticleId라는 변수를 1 추가합니다
				//반복문을 빠져 나갔을때 메인 메서드 밖에 지정해놓은 int 변수에 저장됍니다

			} else if (command.startsWith("article detail")) {//article list가 아닌 article detail을 입력한다면 실행
				//startWith 기능은 ~로 시작하는 단어를 찾는 명령어로
				//해당 article detail 로 시작하는 명령어를 받습니다

				String[] cmdDiv = command.split(" ");
				//문자열 배열에 cmdDiv라는 변수를 지정하고 split(" ") 기능을 넣습니다
				//공백을 기준으로 나눠서 인식하겠단 의미입니다

				if (cmdDiv.length < 3) {//그렇게 공백으로 검산해본 값이 3미만이면 ->article detail 후 입력된게 없음
					System.out.println("명령어를 확인해주세요");//출력
					continue;//해당 반복문을 돌아갑니다
				}

				int id = Integer.parseInt(cmdDiv[2]);
				//int id값을 문자열 배열 cmdDiv[2]값으로 치환하겠단 소리입니다
				//ㅁ ㅁ ㅁ  세번째 ㅁ에 숫자가 들어와도 문자로 인식하겠단 소리입니다

				Article foundArticle = getArticleById(id);
				//Article 타입의 변수 foundArticle에 getArticleById의 메소드 id값을 넣습니다

				if (foundArticle == null) {//found값이 null이라면
					System.out.printf("%d번 게시물은 존재하지 않습니다\n", id);//id값이 없다 출력하고
					continue;//해당 반복문으로 돌아갑니다
				}

				foundArticle.hit++;
				//detail 기능을 할 때마다 조회수가 1씩 증가하도록 합니다

				System.out.println("번호 : " + foundArticle.id);
				System.out.println("작성날짜 : " + foundArticle.regDate);
				System.out.println("수정날짜 : " + foundArticle.updateDate);
				System.out.println("제목 : " + foundArticle.title);
				System.out.println("내용 : " + foundArticle.body);
				System.out.println("조회 : " + foundArticle.hit);
				//여기까지 걸리지 않고 내려왔다면 실행
                //foundArticle.[  ]  찾은 값들을 넣어 출력해줍니다
			} else if (command.startsWith("article modify")) {//article list가 아닌 article modify을 입력한다면 실행

				String[] cmdDiv = command.split(" ");

				if (cmdDiv.length < 3) {
					System.out.println("명령어를 확인해주세요");
					continue;
				}

				int id = Integer.parseInt(cmdDiv[2]);

				Article foundArticle = getArticleById(id);

				if (foundArticle == null) {
					System.out.printf("%d번 게시물은 존재하지 않습니다\n", id);
					continue;
				}//detail과 같은 이유
				
				//여기까지 걸리지 않고 내려왔다면 실행
				System.out.print("새 제목 : ");
				String updateDate = Util.getNowDateTimeStr();
				String newTitle = sc.nextLine();
				System.out.print("새 내용 : ");
				String newBody = sc.nextLine();

				foundArticle.title = newTitle;
				foundArticle.body = newBody;
				foundArticle.updateDate = updateDate;

				System.out.println(id + "번 글을 수정했습니다");

			} else if (command.startsWith("article delete")) {

				String[] cmdDiv = command.split(" ");

				if (cmdDiv.length < 3) {
					System.out.println("명령어를 확인해주세요");
					continue;
				}

				int id = Integer.parseInt(cmdDiv[2]);

				int foundIndex = getArticleIndexById(id);
				//int타입 foundIndex변수에 getArticleIndexById의 메소드 id값을 넣겠다

				if (foundIndex == -1) {//foundIndex의 값이 -1이라면 존재하지 않으므로
					System.out.printf("%d번 게시물은 존재하지 않습니다\n", id);//출력
					continue;//해당 반복문으로 돌아갑니다
				}//detail과 같은 이유

				articles.remove(foundIndex);//여기까지 걸리지 않고 내려왔다면 실행
				System.out.println(id + "번 글을 삭제했습니다");

			} else {//처음 if문과 이어지는 조건문 else
				System.out.println("존재하지 않는 명령어입니다");
			}//여기까지 왔다면 지정해놓은 모든 명령어가 없다는것
		}

		System.out.println("==프로그램 끝==");//exit로 해당 클래스를 break했을때 출력

		sc.close();//스캐너의 기능의 종료  습관화 들이면 좋습니다
	}

	private static int getArticleIndexById(int id) {
		int i = 0;
		for (Article article : articles) {
			if (article.id == id) {
				return i;
			}
			i++;
		}
		return -1;
	}
	
//	이 코드는 id 값에 해당하는 게시물의 인덱스를 찾아주는 메소드입니다.
//	articles는 게시물 정보를 담고 있는 List<Article> 객체로 
//for-each 반복문을 사용하여 모든 게시물을 순차적으로 조회하면서 article.id와 id 값을 비교합니다. 만약 두 값이 일치한다면
//return i를 통해 해당 게시물의 인덱스 i를 반환합니다.	
//	모든 게시물을 조회해도 해당 id 값에 해당하는 게시물을 찾지 못했다면
//return -1을 통해 id 값에 해당하는 게시물이 없음을 나타냅니다.	
//	따라서 이 메소드를 호출하면 id 값에 해당하는 게시물이 존재하는 경우 해당 게시물의 인덱스를 반환하고 존재하지 않는 경우 -1을 반환하게 됩니다.

	private static Article getArticleById(int id) {
		
//		for (int i = 0; i < articles.size(); i++) { 위의 메서드들이 없다면 글의 유무를 판별 할 때 마다
//			Article article = articles.get(i);     이렇게 매번 articles.size의 배열을
//			if (article.id == id) {                일일히 찾아봐야 하므로
//				return article;                     중복값 제거 메서드를 만듭니다
//			}
//		}

//		for (Article article : articles) {
//			if (article.id == id) {
//				return article;
//			}
//		}
		int index = getArticleIndexById(id);

		if (index != -1) {
			return articles.get(index);
		}

		return null;
	}
	
//	이 코드는 id 값에 해당하는 게시물 객체(Article)를 반환하는 메소드입니다.
//	getArticleIndexById 메소드를 호출하여 id 값에 해당하는 게시물의 인덱스를 구하고
//  이 인덱스를 index 변수에 저장합니다
//	index 변수의 값이 -1이 아니라면, articles 리스트에서 
//  index 인덱스에 해당하는 게시물 객체를 return articles.get(index);를 통해 반환합니다
//	근데 index 값이 -1이라면, 해당 id 값에 해당하는 게시물이 존재하지 않는 것이므로 null 값을 반환합니다.
//	따라서 이 메소드를 호출하면 id 값에 해당하는 게시물이 존재하는 경우 해당 게시물 객체를 반환하고 존재하지 않는 경우 null을 반환하게 됩니다.





	
	
	
	
	private static void makeTestData() { // 메인 메서드에 만들어 놓았던 테스트 데이터를 출력하는 메서드
		System.out.println("테스트를 위한 데이터를 생성합니다");
		articles.add(new Article(1, Util.getNowDateTimeStr(), Util.getNowDateTimeStr(), "제목1", "제목1", 11));
		articles.add(new Article(2, Util.getNowDateTimeStr(), Util.getNowDateTimeStr(), "제목2", "제목2", 22));
		articles.add(new Article(3, Util.getNowDateTimeStr(), Util.getNowDateTimeStr(), "제목3", "제목3", 33));
	} //articles 에 저장된 값들을 출력합니다 이때,2번째 생성자가 쓰입니다
}

class Article { // new를 했으니 Article 객체를 만들어줍니다.
	int id;
	String regDate;
	String updateDate;
	String title;
	String body;
	int hit;

	Article(int id, String regDate, String updateDate, String title, String body) {
		this(id, regDate, updateDate, title, body, 0);
	}// 생성자를 만들어 객체를 생성하자 마자 값을 넣어줍니다

	Article(int id, String regDate, String updateDate, String title, String body, int hit) {
		this.id = id;
		this.regDate = regDate;
		this.updateDate = updateDate;
		this.title = title;
		this.body = body;
		this.hit = hit;
	}// 두번째 생성자 입니다 클래스 이름과 똑같이 만들며 위의 생성자와도 이름이 같습니다
		// 하지만 같은 생성자를 만들 때는 메서드의 인자나 타입이 달라야하는데 이것을 오버로딩 과정이라고 합니다.
}