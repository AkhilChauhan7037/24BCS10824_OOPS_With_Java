abstract class EvaluationEngine {
    protected Moderation moderation;

    public EvaluationEngine(Moderation moderation) {
        this.moderation = moderation;
    }

    public final String evaluate(Student s) {
        int theory = collectTheory(s);
        int lab = collectLab(s);
        int total = calculateScore(theory, lab);
        total = moderation.apply(total, s);
        return generateGrade(total);
    }

    protected abstract int collectTheory(Student s);
    protected abstract int collectLab(Student s);
    protected abstract int calculateScore(int theory, int lab);
    protected abstract String generateGrade(int score);
}

class BTechEvaluation extends EvaluationEngine {
    public BTechEvaluation(Moderation m) {
        super(m);
    }

    protected int collectTheory(Student s) {
        return s.theory;
    }

    protected int collectLab(Student s) {
        return s.lab;
    }

    protected int calculateScore(int theory, int lab) {
        return theory * 60 / 100 + lab * 40 / 100;
    }

    protected String generateGrade(int score) {
        if (score >= 75) {
            return "A";
        }
        if (score >= 60) {
            return "B";
        }
        return "C";
    }
}

class MCAEvaluation extends EvaluationEngine {
    public MCAEvaluation(Moderation m) {
        super(m);
    }

    protected int collectTheory(Student s) {
        return s.theory;
    }

    protected int collectLab(Student s) {
        return s.lab;
    }

    protected int calculateScore(int theory, int lab) {
        return theory * 50 / 100 + lab * 50 / 100;
    }

    protected String generateGrade(int score) {
        if (score >= 70) {
            return "A";
        }
        if (score >= 55) {
            return "B";
        }
        return "C";
    }
}

class PhDEvaluation extends EvaluationEngine {
    public PhDEvaluation(Moderation m) {
        super(m);
    }

    protected int collectTheory(Student s) {
        return s.theory;
    }

    protected int collectLab(Student s) {
        return s.lab;
    }

    protected int calculateScore(int theory, int lab) {
        return (theory + lab) / 2;
    }

    protected String generateGrade(int score) {
        if (score >= 80) {
            return "Pass";
        }
        return "Fail";
    }
}

interface Moderation {
    int apply(int score, Student s);
}

class AttendanceModeration implements Moderation {
    public int apply(int score, Student s) {
        if (s.attendance > 75) {
            return score + 5;
        }
        return score;
    }
}

class DifficultyModeration implements Moderation {
    public int apply(int score, Student s) {
        return score + 3;
    }
}

class ManualModeration implements Moderation {
    public int apply(int score, Student s) {
        return score;
    }
}

class Student {
    int theory;
    int lab;
    int attendance;

    public Student(int theory, int lab, int attendance) {
        this.theory = theory;
        this.lab = lab;
        this.attendance = attendance;
    }
}

class MainApp {
    public static void main(String[] args) {
        Student s = new Student(80, 70, 80);
        EvaluationEngine engine = new PhDEvaluation(new AttendanceModeration());
        System.out.println(engine.evaluate(s));
    }
}