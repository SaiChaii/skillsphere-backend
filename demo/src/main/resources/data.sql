-- Create users
INSERT INTO users (id, name, email, password, role) VALUES
  (1, 'Sai', 'sai@example.com', '1234', 'MENTOR'),
  (2, 'Chaitu', 'chaitu@example.com', 'abcd', 'MENTOR'),
  (3, 'Ravi', 'ravi@example.com', 'pass', 'LEARNER'),
  (4, 'Anu', 'anu@example.com', 'anu123', 'BOTH'),
  (5, 'Priya', 'priya@example.com', 'priya456', 'MENTOR');

-- Create Skills
INSERT INTO skill (skill_id, skill_name, description, mentor_id) VALUES
  (101, 'Java', 'Complete Java programming from basics to advanced', 1),
  (102, 'React', 'Frontend development with React and hooks', 2),
  (103, 'Data Structures', 'DSA for tech interviews and CP', 1),
  (104, 'Spring Boot', 'Build REST APIs with Spring Boot', 4),
  (105, 'SQL', 'Mastering SQL queries and joins', 5),
  (106, 'Python', 'Beginner to advanced Python programming', 2),
  (107, 'Machine Learning', 'Supervised and unsupervised ML algorithms', 3),
  (108, 'Deep Learning', 'Neural networks and deep learning models', 3),
  (109, 'Docker', 'Containerization using Docker', 4),
  (110, 'Kubernetes', 'Orchestrating containers with Kubernetes', 4),
  (111, 'AWS', 'Amazon Web Services cloud solutions', 5),
  (112, 'Azure', 'Cloud computing with Microsoft Azure', 5),
  (113, 'Git', 'Version control with Git and GitHub', 1),
  (114, 'C++', 'High performance programming with C++', 2),
  (115, 'C', 'System programming with C', 1),
  (116, 'Node.js', 'Backend development with Node.js', 3),
  (117, 'Express.js', 'Node.js framework for APIs', 3),
  (118, 'MongoDB', 'NoSQL database MongoDB', 5),
  (119, 'PostgreSQL', 'Advanced SQL with PostgreSQL', 5),
  (120, 'TypeScript', 'JavaScript with static typing', 2),
  (121, 'HTML/CSS', 'Web page structuring and styling', 2),
  (122, 'Angular', 'Frontend framework Angular', 2),
  (123, 'Flask', 'Python microframework Flask', 3),
  (124, 'Django', 'High-level Python framework Django', 3),
  (125, 'Kotlin', 'Modern Android development with Kotlin', 1),
  (126, 'Swift', 'iOS app development with Swift', 5),
  (127, 'Blockchain', 'Introduction to blockchain and smart contracts', 4),
  (128, 'Solidity', 'Programming smart contracts in Solidity', 4),
  (129, 'GraphQL', 'API querying with GraphQL', 3),
  (130, 'Power BI', 'Data visualization with Power BI', 5);



