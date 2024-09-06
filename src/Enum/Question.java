package src.Enum;

import java.util.Random;

enum Answer {
    NO, YES, MAYBE, LATER, SOON, NEVER
}
class Question {
    Random rand = new Random();
    Answer ask() {
        int prob = (int) (100 * rand.nextDouble());
        if(prob < 15) return Answer.MAYBE;
        if(prob < 30) return Answer.NO;
        if(prob < 60) return  Answer.YES;
        if(prob < 75) return Answer.LATER;
        if(prob < 98) return  Answer.SOON;
        else return Answer.NEVER;
}
static class AskMe {
        // Статические методы могут быть вызваны без создания экземпляра класса.
        static void answer(Answer result) {
            switch (result) {
                case NEVER -> System.out.println("Никогда");
                case NO -> System.out.println("Нет");
                case YES -> System.out.println("Да");
                case SOON -> System.out.println("Скоро");
                case LATER -> System.out.println("Позже");
                case MAYBE -> System.out.println("Возможно");
            }
        }

        public static void main(String[] args) {
            Question q = new Question();
            answer(q.ask());
            answer(q.ask());
        }
    }

}