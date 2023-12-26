package com.lunch.breakPoint;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/***
 * 점시시간 11:45에 화면 잠금을 하는 프로그램
 * 
 * 스케줄러를 만드는 방법은 크게 2가지이다.
 * 
 * @author user
 *
 */
public class LunchBreakPoint {

	public static void main(String[] args) {

		// Timer timer = new Timer();
		// RunClass runClass = new RunClass(timer);
		//
		// timer.schedule(runClass, 0, 1000 * 60);

		// ScheduledExecutorService 사용
		ScheduledExecutorService schedule = Executors.newScheduledThreadPool(1);

		// 람다식을 사용하기 때문에 1.8 이상에서 사용
		Runnable task = () -> {
			exec();
		};

		schedule.scheduleAtFixedRate(task, 0, 60, TimeUnit.SECONDS); // 1분마다
		// 실행

	}

	private static void exec() {
		LocalDateTime now = LocalDateTime.now();
		if (now.getHour() == 13 && now.getMinute() == 38) {
			try {
				Runtime.getRuntime().exec("rundll32.exe user32.dll,LockWorkStation");
				/*
					rundll32.exe
					Windows 운영체제에서 DLL(Dynamic Link Library)파일을 실행하는데 사용되는 유틸리티이다.
				
					user32.dll
					Windows 사용자 인터페이스 및 그래픽 관련 함수를 제공하는 DLL 파일이다.
				
					LockWorkStation
					작업세션을 잠그는데 사용되는 명령어이다.
				*/
				System.exit(0);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

// class RunClass extends TimerTask {
//
// private Timer timer;
//
// RunClass(Timer timer) {
// this.timer = timer;
// }
//
// @Override
// public void run() {
// exec();
// }
//
// public void exec() {
// try {
// LocalDateTime now = LocalDateTime.now();
// if (now.getHour() == 11 && now.getMinute() == 45) {
// /* Process process = */Runtime.getRuntime().exec("rundll32.exe
// user32.dll,LockWorkStation");
// // process.waitFor();
// timer.cancel();
// System.exit(0);
// }
//
// } catch (IOException e) {
// e.printStackTrace();
// }
// }
//
// }
