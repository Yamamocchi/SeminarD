import java.util.Scanner;

/**
 * Main
 */
public class Main {

  /**
   * モンスターポーカー 
   * 1. モンスターカードをユーザとCPUがランダムに5枚引く モンスターカードは5種類存在し，役によって攻撃力が変わる。2回まで指定したカードを交換できる
   *
   * 2. AP，DPを役に応じて計算し，バトル．DPを超えたAPの場合，差分はプレーヤーあるいはCPUへのダメージとなる 
   * 
   * 3.プレーヤーあるいはCPUのHPが0になったら終わり．
   *
   * @param args
   * @throws InterruptedException
   */

  public static void main(String[] args) throws InterruptedException {
    MonsterPoker mp = new MonsterPoker(); // MonsterPokerクラスをインスタンス化
    Scanner scanner = new Scanner(System.in);// 標準入力
    while (true) {
      mp.drawPhase(scanner);
      mp.battlePhase();
      // 勝敗判定
      // * これもメソッドにしても良いかも
      if (mp.getPlayerHp() <= 0 && mp.getCpuHp() <= 0) { // PlayerとCPUの両方のHPが0になったら引き分け
        System.out.println("引き分け！");
      } else if (mp.getPlayerHp() <= 0) { // PlayerのHPが先に0になったらCPUの負け
        System.out.println("CPU Win!");
      } else if (mp.getCpuHp() <= 0) { // CPUのHPが0になったらPlayerの勝ち
        System.out.println("Player Win!");
      } else {
        Thread.sleep(2000);
        continue; // 勝敗がつくまで判定を続ける
      }
      break;
    }
    scanner.close();
  }
}
