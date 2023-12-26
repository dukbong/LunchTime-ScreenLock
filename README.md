# LuchTime-ScreenLock

### 사용방법
luchBreak 폴더안에 있는 run.bat파일을 실행하면 (기존) 11:45분에 화면 잠금이 됩니다.

### PowerShell 관련 내용
- powerShell에서 별도로 jar파일을 실행시킨다.

```Start-Process -FilePath "java" -ArgumentList "-jar", "경로/JARNAME.jar" -WindowStyle Hidden```

- powerShell에서 jar파일을 실행했을 경우 프로세스 확인 방법

```
# 없는 경우 오류가 난다.
Get-Process -Name "java"

# 없는 경우 오류가 나지 않고 깔끔하게 만드는 방법
try{
	$searchProcess = Get-Process -Name "java"
    
    $searchProcess
} catch {
	Write-OutPut "Not Found Java File"
}
```

- PowerShell을 통해 실행했을때 프로세스 종료하는 방법

```kill -id id값**```

### bat 파일로 실행했을 경우
현재 bat 파일 내부에서는 javaw라는 콘솔 창 없이 Java 애플리케이션을 실행하는 명령어를 사용하고 있다.

그렇기 때문에 PowerShell에서 해당 프로세스를 확인할 수 없다.

이때는 ```tasklist```를 통해 확인할 수 있으며 이름은 javaw.exe라고 되어있다.

종료를 원하는 경우 ```Stop-Process -Id PID값```를 사용할 수 있다.
