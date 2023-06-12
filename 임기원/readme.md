내가 직접 쓰기 귀찮아서 만든 샘플 코드

// 스캐너
Scanner sc = new Scanner(System.in);
int N = sc.nextInt();
int M = sc.nextInt();

// 버버리더 + 스트링토큰라이절
BufferedReader bufferedReader =
new BufferedReader(new InputStreamReader(System.in));
StringTokenizer stringTokenizer =
new StringTokenizer(bufferedReader.readLine());
// 데이터 개수, 질문 개수
int suNo = Integer.parseInt(stringTokenizer.nextToken());
int quizNo = Integer.parseInt(stringTokenizer.nextToken());