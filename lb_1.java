import java.util.Random;
import java.util.Scanner;

interface ITextProcessor {
    String processText(String inputText);
}

class TextProcessor implements ITextProcessor {
    @Override
    public String processText(String inputText) {
        String Glass = "AEIOUYaeiouyАЕЁИОУЫЭЮЯаеёиоуыэюя";
        String sogls = "BCDFGHJKLMNPQRSTVWXZbcdfghjklmnpqrstvwxzБВГДЖЗЙКЛМНПРСТФХЦЧШЩбвгджзйклмнпрстфхцчшщ";
        StringBuilder result = new StringBuilder(inputText);
        Random random = new Random();

        int GlasCount = 0;
        int soglCount = 0;

        // Подсчет количества гласных и согласных
        for (char ch : inputText.toCharArray()) {
            if (Glass.indexOf(ch) != -1) {
                GlasCount++;
            } else if (sogls.indexOf(ch) != -1) {
                soglCount++;
            }
        }

        // Удаление случайных символов для уравнивания количества
        while (GlasCount != soglCount) {
            int index = random.nextInt(result.length());
            char ch = result.charAt(index);

            if (GlasCount > soglCount && Glass.indexOf(ch) != -1) {
                result.deleteCharAt(index);
                GlasCount--;
            } else if (soglCount > GlasCount && sogls.indexOf(ch) != -1) {
                result.deleteCharAt(index);
                soglCount--;
            }
        }

        return result.toString();
    }
}

class ExtendedTextProcessor extends TextProcessor {
    public void countGlAndSogl(String inputText) {
        String Glass = "AEIOUYaeiouyАЕЁИОУЫЭЮЯаеёиоуыэюя";
        String sogls = "BCDFGHJKLMNPQRSTVWXZbcdfghjklmnpqrstvwxzБВГДЖЗЙКЛМНПРСТФХЦЧШЩбвгджзйклмнпрстфхцчшщ";
        int GlasCount = 0;
        int soglCount = 0;

        for (char ch : inputText.toCharArray()) {
            if (Glass.indexOf(ch) != -1) {
                GlasCount++;
            } else if (sogls.indexOf(ch) != -1) {
                soglCount++;
            }
        }

        System.out.println("Количество гласных: " + GlasCount);
        System.out.println("Количество согласных: " + soglCount);
    }
}

class AdvancedTextProcessor extends ExtendedTextProcessor {
    @Override
    public String processText(String inputText) {
        String Glass = "AEIOUYaeiouyАЕЁИОУЫЭЮЯаеёиоуыэюя";
        String sogls = "BCDFGHJKLMNPQRSTVWXZbcdfghjklmnpqrstvwxzБВГДЖЗЙКЛМНПРСТФХЦЧШЩбвгджзйклмнпрстфхцчшщ";
        StringBuilder result = new StringBuilder(inputText);
        Random random = new Random();

        int GlasCount = 0;
        int soglCount = 0;

        // Подсчет количества гласных и согласных
        for (char ch : inputText.toCharArray()) {
            if (Glass.indexOf(ch) != -1) {
                GlasCount++;
            } else if (sogls.indexOf(ch) != -1) {
                soglCount++;
            }
        }

        // Добавление случайных символов для уравнивания количества
        while (GlasCount != soglCount) {
            int index = random.nextInt(result.length() + 1);

            if (GlasCount < soglCount) {
                char Glas = Glass.charAt(random.nextInt(Glass.length()));
                result.insert(index, Glas);
                GlasCount++;
            } else {
                char sogl = sogls.charAt(random.nextInt(sogls.length()));
                result.insert(index, sogl);
                soglCount++;
            }
        }

        return result.toString();
    }
}

public class lb_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите вариант:");
        System.out.println("1. ExtendedTextProcessor");
        System.out.println("2. AdvancedTextProcessor");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера

        ITextProcessor processor;
        if (choice == 1) {
            processor = new ExtendedTextProcessor();
        } else if (choice == 2) {
            processor = new AdvancedTextProcessor();
        } else {
            System.out.println("Неверный выбор.");
            return;
        }

        System.out.println("Введите текст:");
        String inputText = scanner.nextLine();

        System.out.println("Выберите операцию:");
        System.out.println("1. Операция 1");
        System.out.println("2. Операция 2");
        int operation = scanner.nextInt();

        if (operation == 1) {
            String processedText = processor.processText(inputText);
            System.out.println("Результат обработки: " + processedText);
        } else if (operation == 2 && processor instanceof ExtendedTextProcessor) {
            ((ExtendedTextProcessor) processor).countGlAndSogl(inputText);
        } else {
            System.out.println("Неверная операция.");
        }
    }
}