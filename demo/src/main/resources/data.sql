---- Create users
--INSERT INTO users (id, name, email, password, role) VALUES
--  (1, 'Sai', 'sai@example.com', '1234', 'MENTOR'),
--  (2, 'Chaitu', 'chaitu@example.com', 'abcd', 'MENTOR'),
--  (3, 'Ravi', 'ravi@example.com', 'pass', 'LEARNER'),
--  (4, 'Anu', 'anu@example.com', 'anu123', 'BOTH'),
--  (5, 'Priya', 'priya@example.com', 'priya456', 'MENTOR');

-- Skills
INSERT INTO skill (skill_id, skill_name, skill_desc) VALUES
  (101, 'Java', 'Complete Java programming from basics to advanced'),
  (102, 'React', 'Frontend development with React and hooks'),
  (103, 'Data Structures', 'DSA for tech interviews and CP'),
  (104, 'Spring Boot', 'Build REST APIs with Spring Boot'),
  (105, 'SQL', 'Mastering SQL queries and joins'),
  (106, 'Python', 'Beginner to advanced Python programming'),
  (107, 'Machine Learning', 'Supervised and unsupervised ML algorithms'),
  (108, 'Deep Learning', 'Neural networks and deep learning models'),
  (109, 'Docker', 'Containerization using Docker'),
  (110, 'Kubernetes', 'Orchestrating containers with Kubernetes'),
  (111, 'AWS', 'Amazon Web Services cloud solutions'),
  (112, 'Azure', 'Cloud computing with Microsoft Azure'),
  (113, 'Git', 'Version control with Git and GitHub'),
  (114, 'C++', 'High performance programming with C++'),
  (115, 'C', 'System programming with C'),
  (116, 'Node.js', 'Backend development with Node.js'),
  (117, 'Express.js', 'Node.js framework for APIs'),
  (118, 'MongoDB', 'NoSQL database MongoDB'),
  (119, 'PostgreSQL', 'Advanced SQL with PostgreSQL'),
  (120, 'TypeScript', 'JavaScript with static typing'),
  (121, 'HTML/CSS', 'Web page structuring and styling'),
  (122, 'Angular', 'Frontend framework Angular'),
  (123, 'Flask', 'Python microframework Flask'),
  (124, 'Django', 'High-level Python framework Django'),
  (125, 'Kotlin', 'Modern Android development with Kotlin'),
  (126, 'Swift', 'iOS app development with Swift'),
  (127, 'Blockchain', 'Introduction to blockchain and smart contracts'),
  (128, 'Solidity', 'Programming smart contracts in Solidity'),
  (129, 'GraphQL', 'API querying with GraphQL'),
  (130, 'Power BI', 'Data visualization with Power BI');

-- Mentors for skills
INSERT INTO skill_mentors (skill_id, mentor_id) VALUES
  (101, 1), (102, 2), (103, 1), (104, 4), (105, 5),
  (106, 2), (107, 3), (108, 3), (109, 4), (110, 4),
  (111, 5), (112, 5), (113, 1), (114, 2), (115, 1),
  (116, 3), (117, 3), (118, 5), (119, 5), (120, 2),
  (121, 2), (122, 2), (123, 3), (124, 3), (125, 1),
  (126, 5), (127, 4), (128, 4), (129, 3), (130, 5);

-- Learners for skills
INSERT INTO skill_learners (skill_id, learner_id) VALUES
  (101, 1001), (101, 1002),
  (102, 1002), (102, 1003),
  (103, 1004),
  (104, 1001), (104, 1005),
  (105, 1003), (105, 1004), (105, 1005),
  (106, 1006),
  (107, 1002), (107, 1004),
  (108, 1004), (108, 1005),
  (109, 1001),
  (110, 1002), (110, 1006),
  (111, 1003),
  (112, 1005),
  (113, 1006),
  (114, 1001),
  (115, 1002),
  (116, 1003),
  (117, 1004),
  (118, 1005),
  (119, 1001),
  (120, 1002),
  (121, 1003),
  (122, 1004),
  (123, 1005),
  (124, 1006),
  (125, 1001),
  (126, 1002),
  (127, 1003),
  (128, 1004),
  (129, 1005),
  (130, 1006);





