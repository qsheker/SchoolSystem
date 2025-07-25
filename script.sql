-- Clear existing data (optional)
DELETE FROM grades;
DELETE FROM student_courses;
DELETE FROM students;
DELETE FROM courses;
DELETE FROM teachers;
DELETE FROM groups;

-- Insert Groups
INSERT INTO groups (group_name) VALUES
                                    ('10-A'), ('10-B'), ('11-A'), ('11-B'), ('12-A');

-- Insert Teachers
INSERT INTO teachers (first_name, last_name, email) VALUES
                                                        ('John', 'Smith', 'john.smith@school.edu'),
                                                        ('Emily', 'Johnson', 'emily.johnson@school.edu'),
                                                        ('Michael', 'Williams', 'michael.williams@school.edu'),
                                                        ('Sarah', 'Brown', 'sarah.brown@school.edu'),
                                                        ('David', 'Jones', 'david.jones@school.edu');

-- Insert Courses
INSERT INTO courses (course_name, course_code, teacher_id) VALUES
                                                               ('Mathematics', 'MATH-101', 1),
                                                               ('Physics', 'PHYS-101', 2),
                                                               ('Chemistry', 'CHEM-101', 3),
                                                               ('Literature', 'LIT-101', 4),
                                                               ('History', 'HIST-101', 5),
                                                               ('Computer Science', 'CS-101', 1),
                                                               ('Biology', 'BIO-101', 3);

-- Insert Students
INSERT INTO students (first_name, last_name, email, group_id) VALUES
                                                                  ('Robert', 'Wilson', 'robert.wilson@school.edu', 1),
                                                                  ('Jennifer', 'Taylor', 'jennifer.taylor@school.edu', 1),
                                                                  ('Thomas', 'Anderson', 'thomas.anderson@school.edu', 2),
                                                                  ('Lisa', 'Martinez', 'lisa.martinez@school.edu', 2),
                                                                  ('Daniel', 'Garcia', 'daniel.garcia@school.edu', 3),
                                                                  ('Jessica', 'Lee', 'jessica.lee@school.edu', 3),
                                                                  ('Matthew', 'Rodriguez', 'matthew.rodriguez@school.edu', 4),
                                                                  ('Amanda', 'Hernandez', 'amanda.hernandez@school.edu', 4),
                                                                  ('James', 'Miller', 'james.miller@school.edu', 5),
                                                                  ('Elizabeth', 'Davis', 'elizabeth.davis@school.edu', 5),
                                                                  ('Christopher', 'Lopez', 'christopher.lopez@school.edu', 1),
                                                                  ('Ashley', 'Gonzalez', 'ashley.gonzalez@school.edu', 2),
                                                                  ('Joshua', 'Perez', 'joshua.perez@school.edu', 3),
                                                                  ('Michelle', 'Moore', 'michelle.moore@school.edu', 4),
                                                                  ('Andrew', 'Jackson', 'andrew.jackson@school.edu', 5);

-- Enroll Students in Courses
INSERT INTO student_courses (student_id, course_id) VALUES
                                                        (1, 1), (1, 2), (1, 6),
                                                        (2, 1), (2, 3), (2, 4),
                                                        (3, 2), (3, 5), (3, 7),
                                                        (4, 3), (4, 4), (4, 6),
                                                        (5, 1), (5, 5), (5, 7),
                                                        (6, 2), (6, 4), (6, 6),
                                                        (7, 3), (7, 5), (7, 7),
                                                        (8, 1), (8, 2), (8, 4),
                                                        (9, 2), (9, 3), (9, 5),
                                                        (10, 1), (10, 6), (10, 7),
                                                        (11, 3), (11, 4), (11, 5),
                                                        (12, 2), (12, 5), (12, 6),
                                                        (13, 1), (13, 3), (13, 7),
                                                        (14, 4), (14, 5), (14, 6),
                                                        (15, 1), (15, 2), (15, 3);

-- Insert Grades
INSERT INTO grades (grade_value, course_id, student_id) VALUES
                                                            (4.5, 1, 1), (5.0, 2, 1), (4.0, 6, 1),
                                                            (5.0, 1, 2), (4.5, 3, 2), (5.0, 4, 2),
                                                            (4.0, 2, 3), (3.5, 5, 3), (5.0, 7, 3),
                                                            (4.5, 3, 4), (5.0, 4, 4), (4.0, 6, 4),
                                                            (5.0, 1, 5), (4.5, 5, 5), (4.0, 7, 5),
                                                            (3.5, 2, 6), (4.0, 4, 6), (5.0, 6, 6),
                                                            (4.0, 3, 7), (3.5, 5, 7), (4.5, 7, 7),
                                                            (5.0, 1, 8), (4.0, 2, 8), (3.5, 4, 8),
                                                            (4.5, 2, 9), (5.0, 3, 9), (4.0, 5, 9),
                                                            (3.5, 1, 10), (4.5, 6, 10), (5.0, 7, 10),
                                                            (4.0, 3, 11), (3.5, 4, 11), (5.0, 5, 11),
                                                            (5.0, 2, 12), (4.5, 5, 12), (4.0, 6, 12),
                                                            (4.5, 1, 13), (5.0, 3, 13), (3.5, 7, 13),
                                                            (4.0, 4, 14), (5.0, 5, 14), (4.5, 6, 14),
                                                            (3.5, 1, 15), (4.0, 2, 15), (5.0, 3, 15);

-- Assign Teachers to Groups
INSERT INTO teacher_groups (teacher_id, group_id, group_order) VALUES
                                                                   (1, 1, 1), (1, 2, 2),
                                                                   (2, 3, 1), (2, 4, 2),
                                                                   (3, 5, 1), (3, 1, 3),
                                                                   (4, 2, 1), (4, 3, 2),
                                                                   (5, 4, 1), (5, 5, 2);