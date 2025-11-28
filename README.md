# 37-COLLABORATION-ANDROID-MELON
36기 합동세미나 모바일 앱 4팀 멜론 안드로이드 레포입니다.

<BR>

## 🫛 Contributors

| [공승준 (LEAD)](https://github.com/seungjunGong) | [전도연](https://github.com/doyeon0307) | [천민재](https://github.com/cmj7271) |
|:---------------------------:|:-------------------------:|:------------------------------:|
| <img src="https://avatars.githubusercontent.com/u/76648361?v=4" alt="승준" width="250"/> | <img src="https://avatars.githubusercontent.com/u/108921606?v=4" alt="도연" width="250"/> | <img src="https://avatars.githubusercontent.com/u/127363360?v=4" alt="민재" width="250"/> |
|  `ForYou`    |       `홈`       |      `믹스업`      |
<br>

## 🎬 Video 
<video src="https://github.com/user-attachments/assets/7c6742b3-5b7f-4a89-bda4-e66c726e5290
" width="360"/>

<br>

## 🧰 Tech Stack
| 분류               | 사용 기술                    |
| ---------------- | ------------------------ |
| Architecture     | MVVM, Google Architecture |
| Language         | Kotlin                   |
| UI               | Jetpack Compose          |
| DI               | Hilt                     |
| Image Loading    | Coil                     |
| Logging          | Timber                   |
| Lint / Formatter | ktlint                   |

<br>

## ✌️ Package Structure
```
📂 org.sopt.melon
┣ 📂 core
┃ ┣ 📂 common          // 공통 Util, Navigation
┃ ┣ 📂 designsystem
┃ ┃ ┣ 📂 component    // 공통 UI 컴포넌트
┃ ┃ ┣ 📂 theme        // Color, Typography, Shape
┃ ┣ 📂 network        // Network Module, 모델
┃
┣ 📂 data
┃ ┣ 📂 remote              
┃ ┃ ┣ 📂 datasource       
┃ ┃ ┣ 📂 datasourceimpl   
┃ ┃ ┣ 📂 dto              // API 요청/응답 DTO
┃ ┃ ┣ 📂 service          
┃ ┃ ┣ 📂 di              
┃ ┃ 
┃ ┣ 📂 mapper          // DTO ↔ Domain Model 매퍼
┃ ┣ 📂 model           
┃ ┣ 📂 repository     
┃ ┣ 📂 repositoryimpl  
┃ ┣ 📂 di   
┃         
┣ 📂 domain
┃ ┣ 📂 usecase         // UseCase
┃
┣ 📂 presentation
┃ ┣ 📂 main      
┃ ┣ 📂 home         
┃ ┣ 📂 foryou      
┃ ┣ 📂 mixup          
┃
┣ 📂 MelonApplication
```

<br>

## 📝 Convention
- [Git Convention](https://billowy-parakeet-433.notion.site/Git-Convention-2b984ff9088880019965f31016b935c9?source=copy_link)
- [Coding Convention](https://billowy-parakeet-433.notion.site/Android-Coding-Convention-2b984ff9088880a1be5ace2484ceae91?source=copy_link)
