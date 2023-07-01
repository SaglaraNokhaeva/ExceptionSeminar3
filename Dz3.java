/*
Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке,
разделенные пробелом: Фамилия Имя Отчество, дата рождения, номер телефона, пол

Форматы данных:
фамилия, имя, отчество - строки
датарождения - строка формата dd.mm.yyyy
номертелефона - целое беззнаковое число без форматирования
пол - символ латиницей f или m.

Приложение должно проверить введенные данные по количеству. Если количество не совпадает с требуемым,
вернуть код ошибки, обработать его и показать пользователю сообщение, что он ввел меньше и больше данных,
чем требуется.

Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры.
Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы.
Можно использовать встроенные типы java и создать свои. Исключение должно быть корректно обработано,
пользователю выведено сообщение с информацией, что именно неверно.

Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии,
в него в одну строку должны записаться полученные данные, вида

<Фамилия><Имя><Отчество><датарождения> <номер телефона> <пол>

Однофамильцы должны записаться в один и тот же файл, в отдельные строки.

Не забудьте закрыть соединение с файлом.

При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано,
пользователь должен увидеть стектрейс ошибки.

 */

import java.util.Scanner;

public class Dz3 {
    public static void main(String[] args) throws MyFormatException {
        String name = null;
        String dateOfBirth = null;
        char gender = 'a';

//ввод ФИО
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите ФИО: ");
        name = scan.nextLine();
        String rezName = null;
        String[] splitedName = name.split(" ");
        if (splitedName.length == 3) rezName = String.join(", ", splitedName);
        if (rezName != null) {
            System.out.println(rezName);
        } else {
            System.out.println("ФИО заданы в неверном формате, необходимо ввести через пробел");
            throw new MyFormatException();
        }

        //ввод даты рождения
        scan = new Scanner(System.in);
        System.out.println("Введите дату рождения в формате: dd.mm.yyyy: ");
        dateOfBirth = scan.nextLine();
        String rezDateOfBirth = null;
        String[] splitedDateOfBirth = dateOfBirth.split("\\.");
        if ((splitedDateOfBirth.length == 3) & (Integer.parseInt(splitedDateOfBirth[0]) < 32) & (Integer.parseInt(splitedDateOfBirth[0]) > 0) & (Integer.parseInt(splitedDateOfBirth[1]) > 0) & (Integer.parseInt(splitedDateOfBirth[1]) < 13) & (Integer.parseInt(splitedDateOfBirth[2]) > 0) & (Integer.parseInt(splitedDateOfBirth[2]) < 2024)) {
            rezDateOfBirth = String.join(".", splitedDateOfBirth);
        }
        if (rezDateOfBirth != null) {
            System.out.println(rezDateOfBirth);
        } else {
            System.out.println("Дата рождения задана в неверном формате, необходимо ввести чв формате: dd.mm.yyyy: ");
            throw new MyFormatException();
        }


        //ввод телефона


        scan = new Scanner(System.in);
        System.out.println("Введите номер телефона XXXXXXXXXXX: ");
        String phoneStr = scan.nextLine();
        if (phoneStr.length() == 11) {
            Long phone = Long.parseLong(phoneStr);
            System.out.println(phone);
        }


        //ввод пола

        scan = new Scanner(System.in);
        System.out.println("Введите пол (мужской - 'm', женский - 'f'): ");
        gender = scan.next().charAt(0);
        String rezGender = null;
        if ((gender == 'f') | (gender == 'm')) rezGender = String.valueOf(gender);

        if (rezGender != null) {
            System.out.println(rezGender);
        } else {
            System.out.println("Пол задан в неверном формате");
            throw new MyFormatException();
        }
    }

}

