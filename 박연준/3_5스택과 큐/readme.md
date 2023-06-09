# 스택과 큐의 핵심 이론

## 스택
- 후입 선출(LIFO)
- 삽입과 삭제가 한쪽에서만 일어나는 특징을 갖는다.
- 뒤로가기 버튼을 구현할 때 사용된다.

![image](https://github.com/pyjhoop/AlgorihmStudy/assets/59335316/f2b6ec94-7529-4fbd-b0f1-e40d2832ab29)

### 스택과 관련된 주요 용어 및 메서드
- top : 삽입과 삭제가 일어나는 위치.
- push : top 위치에 새로운 데이터를 삽입.
- pop : top 위치에 있는 데이터를 삭제하고 리턴.
- peek : top 위치에 현재 있는 데이터를 리턴.

--- 

## 큐
- 선입 선출(FIFO)
- 은행에서 번호표를 뽑고 번호표 순서대로 먼저 온 고객부터 처리해주는 것과 같다.
- 한쪽은 삽입만, 다른 한쪽은 삭제만 수행하도록 제한하여 만든 자료구조

![image](https://github.com/pyjhoop/AlgorihmStudy/assets/59335316/88234eb9-9a64-4c3f-8477-74eeae20e5e2)

### 큐와 관련된 주요 용어 및 메서드
- rear : 큐에서의 가장 끝 데이터.
- front : 큐에서의 가장 앞 데이터.
- add : rear 부분에 새로운 데이터를 삽입.
- poll : front부분의 데이터를 삭제하고 리턴.
- peek : front 부분의 데이터를 리턴.
